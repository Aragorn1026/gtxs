package com.example.gtxs.xa.branch.service;

import com.example.gtxs.xa.branch.dao.DeptDao;
import com.example.gtxs.xa.branch.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.GtxsXATransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptMapperServiceImpl implements DeptMapperService{

    @Autowired
    private DeptDao deptDao;

    @Autowired
    RestTemplate restTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch-add")    // 事务别名
    public boolean addDept(Dept dept) {
        Map<String,String> map = new HashMap<String,String>();
        restTemplate.getForObject("http://localhost:10623/dept/list",String.class);
//        restTemplate.postForObject("http://localhost:10623/dept/add",map,String.class);
        return deptDao.addDept(dept);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch-queryid")
    public Dept queryById(Integer id) {
        return deptDao.queryById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch-list")
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch-delete")
    public  boolean deleteDept(Integer id) {
        return deptDao.deleteDept(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch-")
    public Integer descDeptno(){
        return deptDao.descDeptno();
    }
}
