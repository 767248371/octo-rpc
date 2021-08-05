package com.meituan.dorado.client;


import com.meituan.dorado.rpc.AsyncContext;
import com.meituan.dorado.rpc.ResponseFuture;
import com.meituan.dorado.test.thrift.api.Echo;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Callable;


public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws TException {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("client.xml");
        Echo.Iface client = (Echo.Iface) beanFactory.getBean("clientProxy");
        LOGGER.info("mtthrift client started!");

        //***************************
        //此处实现你的方法调用 同步
        String result = client.echo("Hello thrift");
        LOGGER.info("*************result:{}", result);
        // 异步
        ResponseFuture<String> future = AsyncContext.getContext().asyncCall(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return client.echo("Hello thrift");
            }
        });
        LOGGER.info("*************result:{}", result);
        //***************************
    }
}

