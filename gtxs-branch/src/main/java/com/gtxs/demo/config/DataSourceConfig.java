package com.gtxs.demo.config;

import com.netease.cloud.gtxs.common.enums.DBType;
import com.netease.cloud.gtxs.core.rm.datasource.JdbcGtxsDataSource;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


//@Configuration
public class DataSourceConfig {


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name = "dataSource")
    @Primary
    public DataSource dataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "gtxsDataSource")
    public JdbcGtxsDataSource getJdbcDataSource(DataSource ds) {
        JdbcGtxsDataSource gtxsDs = new JdbcGtxsDataSource();
        gtxsDs.setDbType(DBType.MYSQL);
        gtxsDs.setTargetDataSource(ds);
        gtxsDs.setIsDefault(true);
        return gtxsDs;
    }
}
