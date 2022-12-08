package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.BeanClassLoaderAware;
import com.whling.small.springframework.beans.factory.BeanFactory;
import com.whling.small.springframework.beans.factory.BeanFactoryAware;
import com.whling.small.springframework.beans.factory.BeanNameAware;
import com.whling.small.springframework.beans.factory.DisposableBean;
import com.whling.small.springframework.beans.factory.InitializingBean;
import com.whling.small.springframework.context.ApplicationContext;
import com.whling.small.springframework.context.ApplicationContextAware;

/**
 * @author whling
 */
public class UserService
        implements
        ApplicationContextAware,
        BeanNameAware,
        BeanClassLoaderAware,
        BeanFactoryAware,
        InitializingBean,
        DisposableBean {

    private String serviceName;

    private UserDao userDao;

    public String queryUserName(String userName) {
        return userDao.queryUserDescByName(userName)
                .orElse(serviceName);
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("6. setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("5. setBeanFactory");
    }

    @Override
    public void setBeanName(String beanName) throws BeansException {
        System.out.println("7. setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("10. afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("8. setApplicationContext");
    }
}
