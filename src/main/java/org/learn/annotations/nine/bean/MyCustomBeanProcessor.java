package org.learn.annotations.nine.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

@Component
public class MyCustomBeanProcessor implements BeanPostProcessor, BeanFactoryAware, DisposableBean {

    private BeanFactory beanFactory;
    private final List<Object> prototypeBeans = new LinkedList<>();

    private static Logger LOG = LogManager.getLogger();

    private static Consumer<DisposableBean> lambdaWrapper(Consumer<DisposableBean> consumer) {
        return i -> {
            try {
                consumer.accept(i);
            } catch (Exception e) {
                LOG.error("Exception destroying the ohect. {}", e.getMessage());
            }
        };
    }

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

            prototypeBeans.stream()
                    .filter(x -> (x instanceof DisposableBean))
                    .map(x -> (DisposableBean)x)
                    .forEach(lambdaWrapper(x -> {
                        try {
                            x.destroy();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }));

            prototypeBeans.clear();
        }
    }
}
