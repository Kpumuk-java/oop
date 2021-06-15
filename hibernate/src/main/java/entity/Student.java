package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity (name = "student")
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    /*public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }*/

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getMark() {
        return mark;
    }

    public Student setMark(int mark) {
        this.mark = mark;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
