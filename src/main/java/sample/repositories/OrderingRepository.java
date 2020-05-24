package sample.repositories;

import sample.entities.OrderingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderingRepository extends CrudRepository<OrderingEntity, Integer>{

}
