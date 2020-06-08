package sample.services;

import sample.entities.TransporterEntity;
import sample.repositories.TransporterRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TransporterService implements TransporterServiceInterface{

    @Autowired(required = true)
    private TransporterRepository repository;

    @Override
    public TransporterEntity findEntityById(int id) {
        TransporterEntity TransporterEntity = repository.findById(id).get();
        return TransporterEntity;
    }

    public TransporterEntity findEntityByName(String name) {
        TransporterEntity transporterEntity = repository.getTransporterEntityByName(name);
        return transporterEntity;
    }

    @Override
    public void save(TransporterEntity TransporterEntity) {
        repository.save(TransporterEntity);
    }
}
