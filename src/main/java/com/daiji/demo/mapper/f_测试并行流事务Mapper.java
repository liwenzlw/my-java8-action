package com.daiji.demo.mapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author zenglw
 * @date 2018/10/6
 */
@Mapper
public interface f_测试并行流事务Mapper {

    @Select("select * from test")
    List<String>  findAll();

    @Insert("insert into test values (#{threadName})")
    void insert(String threadName);
}
