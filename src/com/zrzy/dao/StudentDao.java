package com.zrzy.dao;

import com.work.entity.Student;
import com.work.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/9
 * Time: 18:48
 */
public class StudentDao {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession(); // 获取session

        long l = System.currentTimeMillis(); // 执行开始时间
        session.beginTransaction(); // 开启事物

//        for (int i = 0; i<999; i++){
            Student student =new Student();
            student.setName("张杰");
            student.setSex("男");

            session.save(student);
//        }

       session.getTransaction().commit(); // 事物提交
        session.close(); // 关闭事物

        long l1 = System.currentTimeMillis(); // 执行结束时间

        System.out.println("执行用时"+(l1-l));


    }
}
