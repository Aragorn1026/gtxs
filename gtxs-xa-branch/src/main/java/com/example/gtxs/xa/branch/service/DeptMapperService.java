package com.example.gtxs.xa.branch.service;

import com.example.gtxs.xa.branch.pojo.Dept;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public interface DeptMapperService {

    public boolean addDept(Dept dept);

    public Dept queryById(Integer id);

    public List<Dept> queryAll();

    public List<Dept> query();

    public boolean deleteDept(Integer id);

    public Integer descDeptno();
}
