package fun.kidon;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import fun.kidon.bean.Panda;
import fun.kidon.config.BeanConfig;

/**
 * @qinqidong
 */

public class Application {
    public static void main(String[] args) {
        ApplicationContext context1 = new AnnotationConfigApplicationContext(BeanConfig.class);
        Panda panda1 = context1.getBean("panda", Panda.class);
        System.out.println(panda1);

        ApplicationContext context2 = new ClassPathXmlApplicationContext("application.xml");
        Panda panda2 = context2.getBean("panda", Panda.class);
        System.out.println(panda2);

        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Panda panda3 = beanFactory1.getBean("panda", Panda.class);
        System.out.println(panda3);

        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Object obj1 = beanFactory2.getBean("pandaFactoryBean");
        Object obj2 = beanFactory2.getBean("&pandaFactoryBean");
        Object obj3 = beanFactory2.getBean("panda");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }
}
