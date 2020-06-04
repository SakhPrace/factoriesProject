package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sample.entities.FactoryEntity;
import sample.entities.TransportOperatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransportOperatorRepository extends CrudRepository<TransportOperatorEntity, Integer>{
    @Query("SELECT e FROM TransportOperatorEntity e WHERE e.name = :username")
    TransportOperatorEntity getTransportOperatorEntityByName(@Param("username") String username);
}
