package com.hc;

import com.hc.entity.Dept;
import com.hc.entity.Emp;
import com.hc.entity.User;
import com.hc.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.hibernate.query.Query;
import org.junit.Test;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest {
    @org.junit.Test
    public void fun1() {
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
        StandardServiceRegistryBuilder configure = standardServiceRegistryBuilder.configure(new File("src\\main\\resources\\hibernate.cfg.xml"));
        StandardServiceRegistry serviceRegistry = configure.build();
        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

    }

    @org.junit.Test
    public void fun2() {

        List<Object[]> res = null;
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.getTransaction();
        try {
            transaction.begin();
            String hql = "";
            ;
            Query query = session.createQuery(hql);
            res = query.list();

            for (Object[] objects : res) {
                for (int i = 0; i < objects.length; i++) {
                    System.out.println(objects[i] + "  ");
                    System.out.println();

                }

            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
//            session.rollback();
        } finally {
            session.close();
        }

    }
}