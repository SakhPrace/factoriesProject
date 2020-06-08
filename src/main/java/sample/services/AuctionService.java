package sample.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sample.repositories.AuctionRepository;

@Service
public class AuctionService implements AuctionServiceInterface {

    @Autowired(required = true)
    private AuctionRepository repository;

    @Override
    public AuctionEntity findEntityById(int id) {
        AuctionEntity auctionEntity = repository.findById(id).get();
        return auctionEntity;
    }

    public AuctionEntity findEntityByOrderId(int id) {
        AuctionEntity auctionEntity = repository.getAuctionEntityByOrderId(id);
        return auctionEntity;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void save(AuctionEntity auctionEntity) {
        repository.save(auctionEntity);
    }
}
