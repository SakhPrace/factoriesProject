package sample.repositories;

import sample.entities.FactoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FactoryRepository extends CrudRepository<FactoryEntity, Integer>{

}
