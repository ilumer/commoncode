package code.snippets.java.entity.bionetomany;

import javax.persistence.*;

/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 00:38
 */
@Entity
public class House {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;


    public House(String name) {
        this.name = name;
    }

    public House() {
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
