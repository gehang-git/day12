package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Dept;
import com.xiaoshu.entity.DeptExample;
import com.xiaoshu.entity.DeptVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper extends BaseMapper<Dept> {

	List<DeptVo> findAll(DeptVo deptVo);
	
}