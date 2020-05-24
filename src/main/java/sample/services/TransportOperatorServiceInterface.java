package sample.services;

import sample.entities.TransportOperatorEntity;

import java.util.Optional;

public interface TransportOperatorServiceInterface {

    TransportOperatorEntity findEntityById(Integer id);

    void save(TransportOperatorEntity TransportOperatorEntity);
}
