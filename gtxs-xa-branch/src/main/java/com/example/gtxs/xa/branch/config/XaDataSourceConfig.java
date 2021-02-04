package com.example.gtxs.xa.branch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import com.netease.cloud.gtxs.core.rm.xa.GtxsXADataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

@Configuration
@Component
public class XaDataSourceConfig {

    @Bean
    public DataSource dataSource(DataSourceProperties dataSourceProperties) {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setURL(dataSourceProperties.getUrl());
        xaDataSource.setUser(dataSourceProperties.getUsername());
        xaDataSource.setPassword(dataSourceProperties.getPassword());

        GtxsXADataSource dstpXADataSource = new GtxsXADataSource();
        dstpXADataSource.setTargetXADataSource(xaDataSource);
        dstpXADataSource.setDefault(true);
        return dstpXADataSource;
    }
}
