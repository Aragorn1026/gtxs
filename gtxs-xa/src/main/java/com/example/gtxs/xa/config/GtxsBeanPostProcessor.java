package com.example.gtxs.xa.config;

import com.netease.cloud.gtxs.common.enums.DBType;
import com.netease.cloud.gtxs.core.rm.datasource.JdbcGtxsDataSource;
import com.netease.cloud.gtxs.core.rm.transaction.GtxsTransactionAspectSupport;
import com.netease.cloud.gtxs.core.rm.xa.GtxsXADataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class GtxsBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof GtxsTransactionAspectSupport) {
            return new Spring5GtxsTransactionAspectSupport((GtxsTransactionAspectSupport) bean);
        }
        return bean;
    }
}
