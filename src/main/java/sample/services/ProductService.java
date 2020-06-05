package sample.services;

import sample.entities.ProductEntity;
import sample.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductServiceInterface{

    @Autowired(required = true)
    private ProductRepository repository;

    @Override
    public ProductEntity findEntityById(int id) {
        ProductEntity productEntity = repository.findById(id).get();
        return productEntity;
    }

    @Override
    public void save(ProductEntity productEntity) {
        repository.save(productEntity);
    }
}
