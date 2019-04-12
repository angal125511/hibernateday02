package com.zrzy.dao;
import com.zrzy.entity.Classes;
import com.zrzy.entity.Student;
import com.zrzy.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/9
 * Time: 18:49
 */
public class StudentjunitTest {

    @Test
    public void query(){

        Session session = HibernateUtil.getSession(); // 获取session
        Transaction transaction = session.beginTransaction(); // 开启事物

        Student student = session.get(Student.class,Integer.valueOf(1));
        session.save(student);
        System.out.println(student);

        transaction.commit(); // 事物提交
        session.close(); // 关闭session

    }

    @Test
    public void addStudent(){
        Session session = HibernateUtil.getSession(); //获取session
        Transaction transaction = session.beginTransaction(); // 开启事物
        Student student = new Student();
        student.setName("谢娜");
        student.setSex("女");

        Student student1 = new Student();
        student1.setName("张杰");
        student1.setSex("男");

        session.save(student);
        session.save(student1);

        transaction.commit(); // 事物提交

        session.close(); // 关闭session
    }

    @Test
    public void addStuClass(){ // 添加学生班级

        Session session = HibernateUtil.getSession(); // 获取session
        Transaction transaction = session.beginTransaction(); // 开启事物
        Classes classes = new Classes();

        classes.setName("Java1班");
        session.save(classes);

        Student student = new Student();
        student.setName("谢娜");
        student.setSex("女");

        student.setClasses(classes);

        Student student2 = new Student();
        student2.setName("张杰");
        student2.setSex("男");

        student2.setClasses(classes);
        session.save(student);
        session.save(student2);

        transaction.commit(); //事物提交
        session.close();


    }

    @Test
    public void queryClass(){
        Session session = HibernateUtil.getSession(); // 获取session
        Transaction transaction = session.beginTransaction(); // 开启事物

        Student student = session.get(Student.class,1);
        System.out.println(student.getClasses().getName());

        transaction.commit();
        session.close();
    }
}
