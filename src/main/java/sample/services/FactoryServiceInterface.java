package sample.services;

import sample.entities.FactoryEntity;

import java.util.Optional;

public interface FactoryServiceInterface {

    FactoryEntity findEntityById(int id);

    void save(FactoryEntity factoryEntity);

    FactoryEntity findEntityByName(String name);
}
