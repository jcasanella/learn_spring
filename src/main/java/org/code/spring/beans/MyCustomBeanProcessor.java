package org.code.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.LinkedList;
import java.util.List;

public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private BeanFactory beanFactory;
    private final List<Object> prototypeBeans = new LinkedList<>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (beanFactory.isPrototype(beanName)) {
            synchronized (prototypeBeans) {
                prototypeBeans.add(bean);
            }
        }

        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void destroy() throws Exception {
        synchronized (prototypeBeans) {
            for (Object bean : prototypeBeans) {

                if (bean instanceof DisposableBean) {
                    DisposableBean disposable = (DisposableBean)bean;
                    try {
                        disposable.destroy();
                    }  catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }

            prototypeBeans.clear();
        }
    }
}
