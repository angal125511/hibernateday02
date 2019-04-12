package com.zrzy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/9
 * Time: 18:40
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory=null;
    private static Session session=null;

    static {

        // 注册服务
        Configuration configuration = new Configuration().configure();

        // 获取sessionFactory

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){ // 获取sessionFactory

        return sessionFactory;
    }

    public static Session getSession(){ // 获取session
        session=sessionFactory.openSession();
        return session;
    }
}
