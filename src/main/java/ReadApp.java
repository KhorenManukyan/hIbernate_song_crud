import entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.HibernateUtils;

public class ReadApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(Song.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        Song song = session.get(Song.class, 2);
        Song song1 = session.get(Song.class, 4);
        System.out.println(song);
        System.out.println(song1);
        session.close();

    }
}
