package com.demo.gtxs;

import com.gtxs.demo.dao.DeptDao;
import com.gtxs.demo.pojo.Dept;
import com.gtxs.demo.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptDaoTest {

    @Test
    public void test(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession= MyBatisUtils.getSqlSession();

        DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
        List<Dept> deptList=deptDao.queryAll();
        for (Dept dept : deptList){
            System.out.println(dept);
        }
        //关闭SqlSession
        sqlSession.close();
    }
}
