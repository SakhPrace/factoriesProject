package sample.services;

import sample.entities.FactoryEntity;
import sample.repositories.FactoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactoryService implements FactoryServiceInterface{

    @Autowired
    private FactoryRepository repository;

    @Override
    public Optional<FactoryEntity> findEntityById(Long id) {
        Optional<FactoryEntity> factoryEntity = repository.findById(id);
        return factoryEntity;
    }
}
