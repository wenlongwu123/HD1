package com.hc.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by Administrator on 2016/12/22.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
    }

    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();

    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null)
            session.close();
    }

    //sessionFactory.getCurrentSession()比sessionFactory.openSession()智能：不需要关闭、能自动提高性能（线程内单例），需要在配置文件中加入：
//    	<property name="hibernate.current_session_context_class">thread</property>
}
