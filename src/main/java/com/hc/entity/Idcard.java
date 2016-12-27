package com.hc.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2016/12/27.
 */
@Entity
@Table(name="tb_idcard")
public class Idcard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String address;
@OneToOne
@JoinColumn(name="person_id",unique = true)
private  Person person;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Idcard{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }

    public Idcard() {
    }
    /////////////////////////////////////
//    @OneToOne(mappedBy = "person")
//    private  Person person;
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
}
