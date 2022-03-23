import entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.HibernateUtils;

public class DeleteApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Song song = session.get(Song.class, 5);
        session.delete(song);
        session.getTransaction().commit();
        session.close();
    }
}
