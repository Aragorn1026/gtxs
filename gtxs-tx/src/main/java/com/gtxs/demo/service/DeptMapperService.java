package com.gtxs.demo.service;

import com.gtxs.demo.pojo.Dept;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeptMapperService {

    public boolean addDept(Dept dept);

    public Dept queryById(Integer id);

    public List<Dept> queryAll();

    public boolean deleteDept(Integer id);

    public Integer descDeptno();
}
