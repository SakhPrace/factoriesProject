package sample.services;

import sample.entities.ProductEntity;

import java.util.List;

public interface ProductServiceInterface {

    ProductEntity findEntityById(int id);

    public List<ProductEntity> findAllEntities();

    public ProductEntity findEntityByName(String name);

    void save(ProductEntity productEntity);
}
