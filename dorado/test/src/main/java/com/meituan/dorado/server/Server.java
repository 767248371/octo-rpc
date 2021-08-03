package com.meituan.dorado.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Server {

    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("server.xml");
        LOGGER.info("mtthrift server started!");
    }
}

