package sample.entityManegers;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import sample.entities.FactoryEntity;
import sample.factories.HibernateSessionFactoryUtil;

public class factoryEntityManager {
    public void save(FactoryEntity factoryEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(factoryEntity);
        session.getTransaction().commit();
        session.close();
    }

    public void update(FactoryEntity factoryEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(factoryEntity);
        session.getTransaction().commit();
        session.close();
    }

    public  FactoryEntity loadById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        FactoryEntity factoryEntity = session.get(FactoryEntity.class, id);
        return factoryEntity;
    }

    public FactoryEntity loadByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        FactoryEntity factoryEntity = session.get(FactoryEntity.class, name);
        return factoryEntity;
    }

}
