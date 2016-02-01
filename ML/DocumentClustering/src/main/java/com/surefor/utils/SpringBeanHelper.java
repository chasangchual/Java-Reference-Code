package com.surefor.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chae on 2/1/2016.
 */
public class SpringBeanHelper {
    public static SpringBeanHelper instance = null ;
    private ApplicationContext context = null ;
    private static String BEAN_CONFIG = "SpringBeans.xml" ;

    public static synchronized SpringBeanHelper getInstance() {
        if(instance == null) {
            instance = new SpringBeanHelper() ;
        }
        return instance ;
    }

    public SpringBeanHelper() {
        context = new ClassPathXmlApplicationContext(BEAN_CONFIG);
    }

    public <T> T getBean(String beanId) {
        return (T) context.getBean(beanId) ;
    }
}
