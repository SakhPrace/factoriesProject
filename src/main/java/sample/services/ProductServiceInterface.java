package sample.services;

import sample.entities.ProductEntity;

import java.util.Optional;

public interface ProductServiceInterface {

    ProductEntity findEntityById(int id);

    void save(ProductEntity productEntity);
}
