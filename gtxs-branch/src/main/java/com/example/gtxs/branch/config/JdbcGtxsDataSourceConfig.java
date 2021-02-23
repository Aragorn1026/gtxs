package com.example.gtxs.branch.config;


import com.netease.cloud.gtxs.common.enums.DBType;
import com.netease.cloud.gtxs.core.rm.datasource.JdbcGtxsDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class JdbcGtxsDataSourceConfig {

    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String MYSQL_VALID_QUERY = "SELECT 1";
    private static final String ORACLE_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
    private static final String ORACLE_VALID_QUERY = "SELECT 1 from dual";

    private static final String SEQUENCE = "DSTP_DEMO_SEQ";
    private static final String ORDER_TABLE = "tb_demo_order";
    private static final String COUPON_TABLE = "tb_demo_coupon";
    private static final String STOCK_TABLE = "tb_demo_stock";

    private static final String MAPPER = "classpath:mapper/*Mapper.xml";
    private static final String MYBATIS_CONFIG = "classpath:mybatis-config.xml";

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;


    @Bean(name = "dataSource")
    @Primary
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        if (identifyDbType() == DBType.MYSQL) {
            dataSource.setDriverClassName(MYSQL_DRIVER_CLASS);
            dataSource.setValidationQuery(MYSQL_VALID_QUERY);
        } else if (identifyDbType() == DBType.ORACLE) {
            dataSource.setDriverClassName(ORACLE_DRIVER_CLASS);
            dataSource.setValidationQuery(ORACLE_VALID_QUERY);
        }
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        dataSource.setInitialSize(4);
        dataSource.setMaxTotal(4);
        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(2);
        dataSource.setMaxWaitMillis(5000);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(300000);
        dataSource.setMinEvictableIdleTimeMillis(3600000);
        dataSource.setNumTestsPerEvictionRun(2);

        return dataSource;
    }

    @Bean(name = "gtxsDataSource")
    public JdbcGtxsDataSource getJdbcDataSource(DataSource ds) {
        JdbcGtxsDataSource gtxsDs = new JdbcGtxsDataSource();
        gtxsDs.setTargetDataSource(ds);
        gtxsDs.setIsDefault(true);
        if (identifyDbType() == DBType.ORACLE) {
            Map<String, String> seqMap = new HashMap<>();
            seqMap.put(ORDER_TABLE, SEQUENCE);
            seqMap.put(COUPON_TABLE, SEQUENCE);
            seqMap.put(STOCK_TABLE, SEQUENCE);
            gtxsDs.setSequenceInfo(seqMap);

            gtxsDs.setDbType(DBType.ORACLE);
        }
        return gtxsDs;
    }

    private DBType identifyDbType() {
        String dbType = dbUrl.split(":")[1];
        if (dbType.equalsIgnoreCase("mysql")) {
            return DBType.MYSQL;
        } else if (dbType.equalsIgnoreCase("oracle")) {
            return DBType.ORACLE;
        } else {
            throw new IllegalStateException("not support db type");
        }
    }


}
