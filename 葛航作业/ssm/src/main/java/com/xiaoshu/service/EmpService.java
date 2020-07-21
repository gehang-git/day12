package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.CityMapper;
import com.xiaoshu.dao.EmpMapper;
import com.xiaoshu.entity.City;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.Emp;
import com.xiaoshu.entity.EmpVo;

@Service
public class EmpService {

	
	@Autowired
	private EmpMapper empMapper;

	public PageInfo<EmpVo> findPage(EmpVo empVo, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<EmpVo> elist = empMapper.findAll(empVo);
		return new PageInfo<EmpVo>(elist);
	}

	public Emp findEmpByName(String tbEmpName) {
		Emp emp = new Emp();
		emp.setTbEmpName(tbEmpName);
		return empMapper.selectOne(emp);
	}

	public void delete(int parseInt) {
		empMapper.deleteByPrimaryKey(parseInt);
	}

	public void addEmp(Emp emp) {
		empMapper.insert(emp);
	}

	public void updateEmp(Emp emp) {
		empMapper.updateByPrimaryKeySelective(emp);
	}
	@Autowired
	private CityMapper cityMapper;
	public List<City> findCityByPid(int i) {
		City city = new City();
		city.setPid(i);
		return cityMapper.select(city);
	}

	public List<EmpVo> findAll(EmpVo empVo) {
		return empMapper.findAll(empVo);
	}

	public List<EmpVo> findEcharts() {
		List<EmpVo> findEcharts = empMapper.findEcharts();
		return empMapper.findEcharts();
	}



}
