package sample.services;

import sample.entities.FactoryEntity;

import java.util.Optional;

public interface FactoryServiceInterface {

    FactoryEntity findEntityById(Integer id);

    void save(FactoryEntity factoryEntity);
}
