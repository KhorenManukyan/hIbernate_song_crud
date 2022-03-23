package utils;

import entity.Song;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                Configuration configuration = new Configuration();
                configuration.configure();
                configuration.addAnnotatedClass(Song.class);

                sessionFactory = configuration.buildSessionFactory();
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("session factory object not created because of some issue");
        }

        return sessionFactory;

    }
}
