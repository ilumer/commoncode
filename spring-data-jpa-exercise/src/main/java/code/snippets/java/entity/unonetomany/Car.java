package code.snippets.java.entity.unonetomany;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 00:36
 */
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Wheel> wheels;


    public Car() {
    }

    public Car(String name, List<Wheel> wheels) {
        this.name = name;
        this.wheels = wheels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}
