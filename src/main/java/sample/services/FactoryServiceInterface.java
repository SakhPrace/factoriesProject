package sample.services;

import sample.entities.FactoryEntity;

import java.util.Optional;

public interface FactoryServiceInterface {
    Optional<FactoryEntity> findEntityById(Long id);
}
