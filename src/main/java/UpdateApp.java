import entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import utils.HibernateUtils;

import java.util.Locale;

public class UpdateApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        Song song = session.get(Song.class, 3);
        String as = song.getSongName();
        song.setSongName(song.getSongName().toLowerCase(Locale.ROOT));

        session.beginTransaction();
        session.update(song);
        session.getTransaction().commit();
        session.close();

    }
}
