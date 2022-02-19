package com.zxf.mapper;

import com.zxf.entities.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeptMapper {

    @Select("select * from dept;")
    List<Dept> listDept();
}
