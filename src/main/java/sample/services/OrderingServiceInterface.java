package sample.services;

import sample.entities.OrderingEntity;

import java.util.List;

public interface OrderingServiceInterface {

    OrderingEntity findEntityById(Integer id);

    public List<OrderingEntity> findEntitiesByFactoryId(Integer factoryId);

    void save(OrderingEntity orderingEntity);
}
