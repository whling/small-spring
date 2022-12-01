package com.whling.small.springframework.test;


import com.whling.small.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.whling.small.springframework.beans.factory.support.XmlBeanDefinitionReader;
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

        String ret = userService.queryUserName("h2");
        Assert.assertEquals("world2", ret);

    }
}
