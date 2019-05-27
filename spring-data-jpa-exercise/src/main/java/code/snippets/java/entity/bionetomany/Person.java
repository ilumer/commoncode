package code.snippets.java.entity.bionetomany;

import javax.persistence.*;
import java.util.Collection;


/**
 * Created by ilumer
 * Date : 2019-05-20
 * Time : 00:38
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<House> houseCollections;

    public Person() {
    }

    public Person(String name, Integer age, Collection<House> houseCollections) {
        this.name = name;
        this.age = age;
        this.houseCollections = houseCollections;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Collection<House> getHouseCollections() {
        return houseCollections;
    }

    public void setHouseCollections(Collection<House> houseCollections) {
        this.houseCollections = houseCollections;
    }
}
