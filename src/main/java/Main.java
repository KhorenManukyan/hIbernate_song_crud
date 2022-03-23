import entity.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Song.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Song song1 = new Song();
//
//        song1.setId(5);
//        song1.setSongName("Umbrella");
//        song1.setArtist("Rihanna");

//        song1.setId(2);
//        song1.setSongName("1111111");
//        song1.setArtist("Coy");








        session.beginTransaction();
        session.save(song1);
        session.getTransaction().commit();

        System.out.println("song saved... check db...");

        session.close();

        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        session1.save(new Song(6,"AAA", "BBB"));
        session1.getTransaction().commit();
        session1.close();

    }
}
