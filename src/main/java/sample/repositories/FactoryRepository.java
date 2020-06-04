package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sample.entities.FactoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FactoryRepository extends CrudRepository<FactoryEntity, Integer>{
    @Query("SELECT e FROM FactoryEntity e WHERE e.name = :username")
    FactoryEntity getFactoryEntityByName(@Param("username") String username);

}
