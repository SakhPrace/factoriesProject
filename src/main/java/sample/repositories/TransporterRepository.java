package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.entities.TransporterEntity;

@Repository
public interface TransporterRepository extends CrudRepository<TransporterEntity, Integer>{
    @Query("SELECT e FROM TransporterEntity e WHERE e.name = :username")
    TransporterEntity getTransporterEntityByName(@Param("username") String username);
}
