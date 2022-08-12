package com.mcb.design.pattern.proxy.proxy1;

import com.mcb.design.pattern.proxy.entity.AliServer;
import com.mcb.design.pattern.proxy.entity.Server;

public class AliServerProxy implements Server {
    private AliServer aliServer;

    public AliServerProxy(AliServer aliServer) {
        this.aliServer = aliServer;
    }

    @Override
    public void run() {
        beforeRun();
        aliServer.run();
        afterRun();
    }

    private void beforeRun() {
        System.out.println("静态代理模式前置处理");
    }

    private void afterRun() {
        System.out.println("静态代理模式后置处理");
    }
}
