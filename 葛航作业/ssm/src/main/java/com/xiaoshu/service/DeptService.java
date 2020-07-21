package com.xiaoshu.service;



import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeptMapper;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.DeptVo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


@Service
public class DeptService {

	@Autowired
	DeptMapper deptMapper;
	@Autowired
	private JedisPool jedisPool;

	public PageInfo<DeptVo> findPage(DeptVo deptVo, Integer pageNum, Integer pageSize,String order,String ordername) {
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"id";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		deptVo.setOrderName(ordername+" "+order);
		PageHelper.startPage(pageNum, pageSize);
		List<DeptVo> dlist = deptMapper.findAll(deptVo);
		return new PageInfo<DeptVo>(dlist);
	}

	public void deleteDept(int id) {
		deptMapper.deleteByPrimaryKey(id);
	}

	
	public Dept findDeptByName(String name) {
		Dept dept = new Dept();
		dept.setName(name);
		Dept dept2 = deptMapper.selectOne(dept);
		return dept2;
	}

	public void updateDept(Dept dept) {
		deptMapper.updateByPrimaryKeySelective(dept);
	}

	public void addDept(Dept dept) {
		deptMapper.insert(dept);
	}

	public List<Dept> findAll() {
		//使用redis缓存部门信息
		//1.先查询redis缓存
		Jedis jedis = jedisPool.getResource();
		String json = jedis.get("depts");
		//2.如果有数据，直接返回数据
		if (com.xiaoshu.util.StringUtil.isNotEmpty(json)) {
			System.out.println("从缓存中查询部门");
			return JSONArray.parseArray(json, Dept.class);
			
		}
		//3.如果没有数据，查询DB
		List<Dept> list = deptMapper.selectAll();
		//4.将查询到的数据缓存到redis中
		if (CollectionUtils.isNotEmpty(list)) {
			jedis.set("depts",JSONObject.toJSONString(list));
		}
		System.out.println("从数据库中查询部门");
		return deptMapper.selectAll();
	}
	

	

}
