package com.whling.small.springframework.test.beans;

import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;
import java.util.Optional;

/**
 * @author whling
 */
public class ProxyUserDaoFactoryBean implements FactoryBean<IUserDao> {

    private IUserDao realUserDao;

    public IUserDao getRealUserDao() {
        return realUserDao;
    }

    @Override
    public IUserDao getObject() throws BeansException {
        return (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{getObjectType()}, (proxy, method, args) -> {

                    if ("toString".equals(method.getName())) {
                        return this.toString();
                    }

                    System.out.println("ProxyUserDaoFactoryBean: 代理UserDao before");
                    Optional<String> ret = realUserDao.queryUserDescByName(args[0].toString());
                    System.out.println("ProxyUserDaoFactoryBean: 代理UserDao after");
                    return ret;
                });
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
