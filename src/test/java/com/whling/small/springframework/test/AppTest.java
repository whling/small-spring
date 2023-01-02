package com.whling.small.springframework.test;


import com.whling.small.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.whling.small.springframework.beans.factory.support.XmlBeanDefinitionReader;
import com.whling.small.springframework.context.support.ClasspathXmlApplicationContext;
import com.whling.small.springframework.test.beans.UserService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author whling
 */
public class AppTest {

    @Test
    public void testXmlApplication() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);

        String ret1 = userService.queryUserName("h2");
        Assert.assertEquals("world2", ret1);

    }

    @Test
    public void testClassPathXmlApplicationContext() {
        ClasspathXmlApplicationContext applicationContext = new ClasspathXmlApplicationContext("classpath:spring.xml");

        UserService userService = applicationContext.getBean("userService", UserService.class);

        String ret1 = userService.queryUserName("h2");
        Assert.assertEquals("world2", ret1);

        String ret2 = userService.queryUserName("b");
        Assert.assertNotEquals("junitTestUserService", ret2);
        Assert.assertEquals("junitTestUserService.BeanFactoryPostProcessor", ret2);

//        Object proxyUserDao = applicationContext.getBean("proxyUserDao");
//
//        boolean b = proxyUserDao instanceof FactoryBean;
//        System.out.println(b);
    }
}
