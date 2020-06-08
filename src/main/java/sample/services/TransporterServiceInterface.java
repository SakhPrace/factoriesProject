package sample.services;

import sample.entities.TransporterEntity;

public interface TransporterServiceInterface {

    TransporterEntity findEntityById(int id);

    void save(TransporterEntity TransporterEntity);

    TransporterEntity findEntityByName(String name);
}
