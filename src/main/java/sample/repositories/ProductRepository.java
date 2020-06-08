package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sample.entities.ProductEntity;
import org.apache.ibatis.annotations.*;
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer>{

}
