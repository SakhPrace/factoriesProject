package sample.services;

import sample.entities.OrderingEntity;

public interface OrderingServiceInterface {

    OrderingEntity findEntityById(Integer id);

    void save(OrderingEntity orderingEntity);
}
