package com.example.gtxs.xa.branch.service;

import com.example.gtxs.xa.branch.dao.DeptDao;
import com.example.gtxs.xa.branch.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.GtxsXATransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptMapperServiceImpl implements DeptMapperService{

    @Autowired
    private DeptDao deptDao;

    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @GtxsXATransaction(name = "xabranch")
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept queryById(Integer id) {
        return deptDao.queryById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch")
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch")
    public  boolean deleteDept(Integer id) {
        return deptDao.deleteDept(id);
    }

    @Override
    public Integer descDeptno(){
        return deptDao.descDeptno();
    }
}
