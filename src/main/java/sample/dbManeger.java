package sample;


import sample.entities.FactoryEntity;
import sample.entityManegers.FactoryEntityManager;

public class dbManeger {
    public static void saveFactoryTestData() {
        FactoryEntity factoryEntityFirst = FactoryEntityManager.createFactoryEntity(0, "First", 0);
        FactoryEntity factoryEntitySecond = FactoryEntityManager.createFactoryEntity(1, "Second", 1);
        FactoryEntity factoryEntityThird = FactoryEntityManager.createFactoryEntity(2, "Third", 2);

        FactoryEntityManager.save(factoryEntityFirst);
        FactoryEntityManager.save(factoryEntitySecond);
        FactoryEntityManager.save(factoryEntityThird);
    }
}
