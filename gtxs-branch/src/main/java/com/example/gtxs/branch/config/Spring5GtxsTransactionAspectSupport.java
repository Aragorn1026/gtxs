package com.example.gtxs.branch.config;

import com.netease.cloud.gtxs.core.rm.transaction.GtxsTransactionAspectSupport;

public class Spring5GtxsTransactionAspectSupport extends GtxsTransactionAspectSupport {
    private GtxsTransactionAspectSupport target;
    public Spring5GtxsTransactionAspectSupport(GtxsTransactionAspectSupport target) {
        this.target = target;
    }
    @Override
    public int getOrder() {
        return super.getOrder();
    }

    @Override
    public void afterPropertiesSet() {
    }
}
