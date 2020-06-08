package sample.services;

import sample.entities.ProductEntity;

public interface ProductServiceInterface {

    ProductEntity findEntityById(int id);

    void save(ProductEntity productEntity);
}
