package sample.services;

import sample.entities.FactoryEntity;
import sample.repositories.FactoryRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FactoryService implements FactoryServiceInterface{

    @Autowired(required = true)
    private FactoryRepository repository;

    @Override
    public FactoryEntity findEntityById(int id) {
        FactoryEntity factoryEntity = repository.findById(id).get();
        return factoryEntity;
    }

    public FactoryEntity findEntityByName(String name) {
        FactoryEntity factoryEntity = repository.getFactoryEntityByName(name);
        return factoryEntity;
    }

    @Override
    public void save(FactoryEntity factoryEntity) {
        repository.save(factoryEntity);
    }
}
