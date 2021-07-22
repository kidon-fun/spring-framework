package fun.kidon.bean;

/**
 * @author qinqidong
 */
public class Panda {

    private Integer id;

    private String name;

    public Panda() {
    }

    public Panda(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Panda{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
