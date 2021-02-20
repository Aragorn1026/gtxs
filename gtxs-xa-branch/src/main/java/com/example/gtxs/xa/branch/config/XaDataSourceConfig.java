package com.example.gtxs.xa.branch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.netease.cloud.gtxs.core.rm.xa.GtxsXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import javax.sql.DataSource;
import javax.sql.XAConnection;

import oracle.jdbc.xa.client.OracleXADataSource;
import java.sql.SQLException;


@Configuration
@Component
public class XaDataSourceConfig {

    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) throws SQLException{
//        mysql数据源
//        MysqlXADataSource xaDataSource = new MysqlXADataSource();

        // Oracle数据源
        OracleXADataSource xaDataSource = new OracleXADataSource();

        xaDataSource.setURL(dataSourceProperties.getUrl());
        xaDataSource.setUser(dataSourceProperties.getUsername());
        xaDataSource.setPassword(dataSourceProperties.getPassword());
        GtxsXADataSource dstpXADataSource = new GtxsXADataSource();
        dstpXADataSource.setTargetXADataSource(xaDataSource);
        dstpXADataSource.setDefault(true);
        return dstpXADataSource;

    }
}
