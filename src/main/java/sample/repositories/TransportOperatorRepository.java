package sample.repositories;

import sample.entities.TransportOperatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransportOperatorRepository extends CrudRepository<TransportOperatorEntity, Integer>{

}
