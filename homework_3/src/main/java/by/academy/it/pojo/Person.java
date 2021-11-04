package by.academy.it.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "persons")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;

    @Column (name = "age")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Id: " + id
                + "\nName: " + name
                + "\nSurname: " + surname
                + "\nAge: " + age + "\n";
    }
}
