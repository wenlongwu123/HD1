package com.hc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/22.
 */
@Entity
@NamedQuery(name="queryAll",query="from Emp ")
@Table(name="tb_emp")
public class Emp {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer empno;
    private  String ename;
    private  String job;
    private  Integer mgr;
    private Date hiredate;
    private  float sal;
    private  float comm;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public Emp() {
    }

    public Emp(Integer empno, String ename, float sal, Dept dept) {
        this.empno = empno;
        this.ename = ename;
        this.sal = sal;
        this.dept = dept;
    }

    public Emp(String ename, String job, Integer mgr, Date hiredate, float sal, float comm) {
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +

                '}';
    }

    ////////////////////////////////////////////////////////////
   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JoinColumn(name="deptno")
   private  Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
