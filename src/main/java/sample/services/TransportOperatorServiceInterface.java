package sample.services;

import sample.entities.FactoryEntity;
import sample.entities.TransportOperatorEntity;

import java.util.Optional;

public interface TransportOperatorServiceInterface {

    TransportOperatorEntity findEntityById(int id);

    void save(TransportOperatorEntity TransportOperatorEntity);

    TransportOperatorEntity findEntityByName(String name);
}
