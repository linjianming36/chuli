package com.ming.data.mqtt;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

@Component
public class SpringUtil extends ApplicationObjectSupport {
    public static ApplicationContext context;

    public static Object getBean(String classService){
        return context.getBean(classService);
    }

    @Override
    protected void initApplicationContext(ApplicationContext context) throws BeansException {
        super.initApplicationContext(context);
        SpringUtil.context = context;
    }
}

