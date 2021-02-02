package com.example.gtxs.xa.branch.config;

import com.netease.cloud.gtxs.core.ComponentScanner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GtxsConfig {
    // GTXS-Server的域名,轻舟分布式事务用户向导页面可以看到，注意每个部署环境都不同
    @Value("${gtxs.server.address}")
    private String serverAddress;

    // 应用名称，也是在注册中心注册的名称
    @Value("${spring.application.name}")
    private String appName;

    // 轻舟控制台创建groupId
    @Value("${gtxs.client.txGroupId}")
    private String groupId;

    @Bean(name = "componentScanner")
    @Qualifier("componentScanner")
    public ComponentScanner getComponentScanner() {
        return new ComponentScanner(groupId, serverAddress, appName);
    }

}
