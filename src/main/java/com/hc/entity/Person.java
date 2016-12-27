package com.hc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/27.
 */
@Entity
@Table(name="tb_person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String name;
    @Column(name="sex")
    private  char gender;
    private Date birth;
    @Column(columnDefinition = "boolean DEFAULT 0")
    private  boolean married;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", married=" + married +
                '}';
    }

    public Person() {
    }

    ////////////////////////////
    @OneToOne(mappedBy = "person")
    private  Idcard idcard;

    public Idcard getIdcard() {
        return idcard;
    }

    public void setIdcard(Idcard idcard) {
        this.idcard = idcard;
    }
}
