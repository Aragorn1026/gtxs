package com.example.gtxs.xa.service;

import com.example.gtxs.xa.dao.DeptDao;
import com.example.gtxs.xa.pojo.Dept;
import com.netease.cloud.gtxs.core.annotation.GtxsXATransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class DeptTransaXaServiceImpl implements com.example.gtxs.xa.service.DeptTransaXaService{

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private RestTemplate restTemplate;

    @Transactional(rollbackFor = Exception.class)
    @GtxsXATransaction(name = "xatx")
    public void addDept(Dept dept){
        deptDao.addDept(dept);

//        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
//        paramMap.add("dname", "信息部");
//        restTemplate.postForObject("http://127.0.0.1:12306/transa/xa/add",paramMap,String.class);
//        throw new RuntimeException("gtxs xa mode 测试报个错");
    }
}
