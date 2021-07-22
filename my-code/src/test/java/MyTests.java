import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

import fun.kidon.bean.GrowablePanda;
import fun.kidon.bean.Panda;

/**
 * @author qinqidong
 */

public class MyTests {

    @Test
    void registerBeanDefinitionTest() {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();

        // 设置属性值
        MutablePropertyValues pvs = new MutablePropertyValues();
        pvs.add("id", 1);
        pvs.add("name", "qidong");

        bf.registerBeanDefinition("panda1", new RootBeanDefinition(Panda.class, null, pvs));
        Panda panda1 = bf.getBean("panda1", Panda.class);
        System.out.println(panda1);

        // 设置构造参数值
        ConstructorArgumentValues cargs = new ConstructorArgumentValues();
        cargs.addIndexedArgumentValue(0, 2);
        cargs.addIndexedArgumentValue(1, "huahua");

        bf.registerBeanDefinition("panda2", new RootBeanDefinition(Panda.class, cargs, null));
        Panda panda2 = bf.getBean("panda2", Panda.class);
        System.out.println(panda2);

        pvs.add("age", 1);
        bf.registerBeanDefinition("panda3", new ChildBeanDefinition("panda1", GrowablePanda.class, null, pvs));
        Panda panda3 = bf.getBean("panda3", Panda.class);
        System.out.println(panda3);
        System.out.println(Arrays.toString(bf.getBeanDefinition("panda3").attributeNames()));

    }

    @Test
    void factoryBeanTest() {
        BeanFactory beanFactory2 = new XmlBeanFactory(new ClassPathResource("application.xml"));
        Object obj1 = beanFactory2.getBean("pandaFactoryBean");
        Object obj2 = beanFactory2.getBean("&pandaFactoryBean");
        Object obj3 = beanFactory2.getBean("panda");
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);
    }

}
