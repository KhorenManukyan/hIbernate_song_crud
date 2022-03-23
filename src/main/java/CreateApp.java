import entity.Song;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Song.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

/*
        Session s = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.createNativeQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate();
            s.createNativeQuery("DROP DATABASE restaurantapp").executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            s.close();
        }
*/

        Session session = sessionFactory.openSession();

        Song song = new Song();

        song.setId(8);
        song.setSongName("Umbrella");
        song.setArtist("Rihanna");


        session.beginTransaction();
        session.save(song);
        session.getTransaction().commit();

        System.out.println("song saved... ");

        session.close();
    }

}
