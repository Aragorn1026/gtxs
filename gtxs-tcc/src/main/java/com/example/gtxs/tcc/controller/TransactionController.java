package com.example.gtxs.tcc.controller;

import com.example.gtxs.tcc.pojo.Dept;
import com.example.gtxs.tcc.service.DeptMapperService;
import com.netease.cloud.gtxs.core.annotation.GtxsTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("transa")
public class TransactionController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DeptMapperService deptMapperService;

    @PostMapping("fmt/add")
    @GtxsTransaction(name = "fmttx")
    @Transactional(rollbackFor = Exception.class)
    public void TransactionFmtMode(Dept dept){
//      本地事务，当前不记入gtxs日志
        deptMapperService.addDept(dept);

        MultiValueMap<String,Object> paramMap = new LinkedMultiValueMap();
        paramMap.add("dname", "运行部");
        restTemplate.postForEntity("http://127.0.0.1:12342/transa/fmt/add", paramMap, String.class, new Object[0]);

        System.out.println("gtxs fmt tx comfire");
        throw new RuntimeException("gtxs fmt mode 测试报个错");
    }

    @PostMapping("tcc/add")
    @GtxsTransaction(name = "tcctx")
    @Transactional(rollbackFor = Exception.class)
    public void TransactionTccMode(Dept dept){
//      本地事务，当前不记入gtxs日志
        deptMapperService.addDept(dept);
//      远程post调用
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("dname", "生产部");
        restTemplate.postForObject("http://127.0.0.1:12342/transa/tcc/add",paramMap,String.class);

        System.out.println("gtxs tcc tx comfire");
//      抛出自定义异常
        throw new RuntimeException("gtxs tcc mode 测试报个错");
    }

    @PostMapping("saga/add")
    @GtxsTransaction(name = "sagatx")
    @Transactional(rollbackFor = Exception.class)
    public void TransactionSagaMode(Dept dept){

        deptMapperService.addDept(dept);

        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("dname", "生产部");
        restTemplate.postForObject("http://127.0.0.1:12342/transa/saga/add",paramMap,String.class);

        System.out.println("gtxs tcc saga comfire");

        throw new RuntimeException("gtxs saga mode 测试报个错");

    }

}
