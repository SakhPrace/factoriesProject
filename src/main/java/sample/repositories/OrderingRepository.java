package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sample.entities.FactoryEntity;
import sample.entities.OrderingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderingRepository extends CrudRepository<OrderingEntity, Integer>{
    @Query("SELECT e FROM OrderingEntity e WHERE e.idFactory = :factoryId AND e.idTransport IS NOT NULL")
    List<OrderingEntity> getOrderingEntitiesByFactoryIdWithTransport(@Param("factoryId") int factoryId);
    @Query("SELECT e FROM OrderingEntity e WHERE e.idFactory = :factoryId AND e.idTransport IS NULL")
    List<OrderingEntity> getOrderingEntitiesByFactoryIdWithoutTransport(@Param("factoryId") int factoryId);

}
