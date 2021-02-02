package com.example.gtxs.xa.branch.config;

import com.netease.cloud.gtxs.core.rm.transaction.GtxsTransactionAspectSupport;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


@Component
public class GtxsBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof GtxsTransactionAspectSupport) {
            return new com.example.gtxs.xa.branch.config.Spring5GtxsTransactionAspectSupport((GtxsTransactionAspectSupport) bean);
        }
        return bean;
    }
}
