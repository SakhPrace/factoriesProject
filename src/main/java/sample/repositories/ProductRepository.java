package sample.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.entities.ProductEntity;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{

}
