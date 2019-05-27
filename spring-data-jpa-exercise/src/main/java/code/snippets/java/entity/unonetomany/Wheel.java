package code.snippets.java.entity.unonetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 00:37
 */
@Entity
public class Wheel {

    @Id
    @GeneratedValue
    private Long id;


    private String name;

    public Wheel(String name) {
        this.name = name;
    }

    public Wheel() {
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
}
