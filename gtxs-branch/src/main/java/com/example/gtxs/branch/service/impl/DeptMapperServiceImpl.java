package com.example.gtxs.branch.service.impl;

import com.example.gtxs.branch.dao.DeptDao;
import com.example.gtxs.branch.pojo.Dept;
import com.example.gtxs.branch.service.DeptMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptMapperServiceImpl implements DeptMapperService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }


    @Override
    public Dept queryById(Integer id) {
        return deptDao.queryById(id);
    }

    @Override
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    public  boolean deleteDept(Integer id) {
        return deptDao.deleteDept(id);
    }

    @Override
    public Integer descDeptno(){ return deptDao.descDeptno();
    }
}
