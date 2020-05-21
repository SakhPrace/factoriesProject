package sample.entityManegers;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import sample.entities.FactoryEntity;
import sample.factories.HibernateSessionFactoryUtil;

public class FactoryEntityManager {
    public static void save(FactoryEntity factoryEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(factoryEntity);
        session.getTransaction().commit();
        session.close();
    }

    public static void update(FactoryEntity factoryEntity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(factoryEntity);
        session.getTransaction().commit();
        session.close();
    }

    public static FactoryEntity loadById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        FactoryEntity factoryEntity = session.get(FactoryEntity.class, id);
        return factoryEntity;
    }

    public static FactoryEntity loadByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        FactoryEntity factoryEntity = session.get(FactoryEntity.class, name);
        return factoryEntity;
    }

    public static FactoryEntity createFactoryEntity(int id, String name, int exportid) {
        FactoryEntity factoryEntity = new FactoryEntity();
        factoryEntity.setId(id);
        factoryEntity.setName(name);
        factoryEntity.setExportid(exportid);
        return factoryEntity;
    }
}
