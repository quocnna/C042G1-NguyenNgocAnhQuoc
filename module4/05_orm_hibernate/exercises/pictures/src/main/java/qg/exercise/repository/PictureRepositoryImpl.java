package qg.exercise.repository;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import qg.exercise.model.Picture;

import java.util.List;

public class PictureRepositoryImpl implements  PictureRepository {

        static {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            sessionFactory.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Picture> findAll() {
        return null;
    }

    @Override
    public Picture findOne(Long id) {
        return null;
    }

    @Override
    public Picture save(Picture picture) {
        return null;
    }
}
