package test;

import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory1 = HibernateUtils.getSessionFactory();
        SessionFactory sessionFactory2 = HibernateUtils.getSessionFactory();

        System.out.println(sessionFactory1 + " - " + sessionFactory2);

        if (sessionFactory1 == sessionFactory2){
            System.out.println("two of the session factory objects are same");
        }
    }
}
