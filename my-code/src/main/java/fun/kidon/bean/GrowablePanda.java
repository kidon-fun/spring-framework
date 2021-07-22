package fun.kidon.bean;

/**
 * @author qinqidong
 */
public class GrowablePanda extends Panda {

    private Integer age;

    public GrowablePanda() {
    }

    public GrowablePanda(Integer id, String name, Integer age) {
        super(id, name);
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "GrowablePanda{" + "id=" + getId() + "," + "name=" + getName() + "," + "age=" + age + '}';
    }
}
