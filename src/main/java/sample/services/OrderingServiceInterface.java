package sample.services;

import sample.entities.OrderingEntity;

import java.util.List;

public interface OrderingServiceInterface {

    OrderingEntity findEntityById(Integer id);

    List<OrderingEntity> findEntitiesByFactoryIdWithTransport(Integer factoryId);

    List<OrderingEntity> findEntitiesByFactoryIdWithoutTransport(Integer factoryId);

    void save(OrderingEntity orderingEntity);
}
