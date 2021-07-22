package fun.kidon.factorybean;

import org.springframework.beans.factory.FactoryBean;

import fun.kidon.bean.Panda;

/**
 * @author qinqidong
 */
public class PandaFactoryBean implements FactoryBean<Panda> {

    @Override
    public Panda getObject() throws Exception {
        return new Panda(2, "huahua");
    }

    @Override
    public Class<?> getObjectType() {
        return Panda.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
