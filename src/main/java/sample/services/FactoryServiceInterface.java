package sample.services;

import sample.entities.FactoryEntity;

public interface FactoryServiceInterface {
    FactoryEntity findEntityById(int id);

    void save(FactoryEntity factoryEntity);

    FactoryEntity findEntityByName(String name);
}
