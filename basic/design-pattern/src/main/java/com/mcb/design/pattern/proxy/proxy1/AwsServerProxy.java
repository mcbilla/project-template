package com.mcb.design.pattern.proxy.proxy1;

import com.mcb.design.pattern.proxy.entity.AwsServer;
import com.mcb.design.pattern.proxy.entity.Server;

public class AwsServerProxy implements Server {
    private AwsServer awsServer;

    public AwsServerProxy(AwsServer awsServer) {
        this.awsServer = awsServer;
    }

    @Override
    public void run() {
        beforeRun();
        awsServer.run();
        afterRun();
    }

    private void beforeRun() {
        System.out.println("静态代理模式前置处理");
    }

    private void afterRun() {
        System.out.println("静态代理模式后置处理");
    }
}
