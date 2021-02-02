package com.gtxs.demo.config;

import com.netease.cloud.gtxs.common.enums.DBType;
import com.netease.cloud.gtxs.core.rm.datasource.JdbcGtxsDataSource;
import com.netease.cloud.gtxs.core.rm.transaction.GtxsTransactionAspectSupport;
import com.netease.cloud.gtxs.core.rm.xa.GtxsXADataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class GtxsBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof GtxsTransactionAspectSupport) {
            return new GtxsTransactionAspectSupport(){
                @Override
                public void afterPropertiesSet() {
                }
            };
        }
        else if (bean instanceof DataSource &&
                !(bean instanceof JdbcGtxsDataSource) &&
                !(bean instanceof GtxsXADataSource)) {
            JdbcGtxsDataSource gtxsDataSource = new JdbcGtxsDataSource();
            gtxsDataSource.setTargetDataSource((DataSource)bean);
            gtxsDataSource.setIsDefault(true);
            gtxsDataSource.setDbType(DBType.MYSQL);
            return gtxsDataSource;
        }
        return bean;
    }
}
