package sample.services;

import sample.entities.TransportOperatorEntity;
import sample.repositories.TransportOperatorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportOperatorService implements TransportOperatorServiceInterface{

    @Autowired(required = true)
    private TransportOperatorRepository repository;

    @Override
    public TransportOperatorEntity findEntityById(Integer id) {
        TransportOperatorEntity TransportOperatorEntity = repository.findById(id).get();
        return TransportOperatorEntity;
    }

    @Override
    public void save(TransportOperatorEntity TransportOperatorEntity) {
        repository.save(TransportOperatorEntity);
    }
}
