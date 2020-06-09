package sample.services;

import sample.entities.FactoryEntity;

import java.util.List;

public interface FactoryServiceInterface {
    FactoryEntity findEntityById(int id);

    void save(FactoryEntity factoryEntity);

    public String shortestWay(int origId, int destId);

    public int shortestWayWeight(int origId, int destId);

    public List<FactoryEntity> findEntitiesByProductIdWithoutFactoryId(int productId, int factoryId);

    FactoryEntity findEntityByName(String name);
}
