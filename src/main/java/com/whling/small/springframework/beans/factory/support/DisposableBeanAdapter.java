package com.whling.small.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.whling.small.springframework.beans.BeansException;
import com.whling.small.springframework.beans.factory.DisposableBean;

import java.lang.reflect.Method;

/**
 * @author whling
 */
public class DisposableBeanAdapter implements DisposableBean {

    private Object bean;

    private String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, String destroyMethodName) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotEmpty(destroyMethodName)
                && !StrUtil.equals(destroyMethodName, DESTROY_METHOD_NAME)) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (method == null) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            method.invoke(bean);
        }
    }
}
