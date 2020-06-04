package sample.services;

import sample.entities.AuctionEntity;
import sample.repositories.AuctionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuctionService implements AuctionServiceInterface{

    @Autowired(required = true)
    private AuctionRepository repository;

    @Override
    public AuctionEntity findEntityById(Integer id) {
        AuctionEntity auctionEntity = repository.findById(id).get();
        return auctionEntity;
    }

    public AuctionEntity findEntityByName(String name) {
        AuctionEntity auctionEntity = repository.getAuctionEntityByName(name);
        return auctionEntity;
    }

    @Override
    public void save(AuctionEntity auctionEntity) {
        repository.save(auctionEntity);
    }
}
