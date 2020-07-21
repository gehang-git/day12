package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.City;
import com.xiaoshu.entity.CityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper extends BaseMapper<City> {
    long countByExample(CityExample example);

    int deleteByExample(CityExample example);

    List<City> selectByExample(CityExample example);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityExample example);

    int updateByExample(@Param("record") City record, @Param("example") CityExample example);
}