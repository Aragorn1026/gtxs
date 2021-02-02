package com.example.gtxs.xa.branch.service;

import com.example.gtxs.xa.branch.dao.DeptDao;
import com.example.gtxs.xa.branch.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.GtxsXATransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class DeptTransaXaServiceImpl implements DeptTransaXaService{

    @Autowired
    private DeptDao deptDao;

    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xabranch")
    public void addDept(Dept dept){
        deptDao.addDept(dept);

//        throw new RuntimeException("gtxs xa mode 测试报个错");
    }
}
