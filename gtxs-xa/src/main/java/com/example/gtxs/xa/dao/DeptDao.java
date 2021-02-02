package com.example.gtxs.xa.dao;

import com.example.gtxs.xa.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryById(Integer id);

    public List<Dept> queryAll();

    public boolean deleteDept(Integer id);

    public Integer descDeptno();

}
