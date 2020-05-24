package sample.services;

import sample.entities.OrderingEntity;
import sample.repositories.OrderingRepository;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderingService implements OrderingServiceInterface {

    @Autowired(required = true)
    private OrderingRepository repository;

    @Override
    public OrderingEntity findEntityById(Integer id) {
        OrderingEntity orderingEntity = repository.findById(id).get();
        return orderingEntity;
    }

    @Override
    public void save(OrderingEntity orderingEntity) {
        repository.save(orderingEntity);
    }
}
