package sample.services;

import sample.entities.OrderingEntity;
import sample.repositories.OrderingRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OrderingService implements OrderingServiceInterface {

    @Autowired(required = true)
    private OrderingRepository repository;

    @Override
    public OrderingEntity findEntityById(Integer id) {
        OrderingEntity orderingEntity = repository.findById(id).get();
        return orderingEntity;
    }

    public List<OrderingEntity> findEntitiesByFactoryIdWithTransport(Integer factoryId) {
        return repository.getOrderingEntitiesByFactoryIdWithTransport(factoryId);
    }

    public List<OrderingEntity> findEntitiesByFactoryIdWithoutTransport(Integer factoryId) {
        return repository.getOrderingEntitiesByFactoryIdWithoutTransport(factoryId);
    }

    @Override
    public void save(OrderingEntity orderingEntity) {
        repository.save(orderingEntity);
    }
}
