package sample.services;

import sample.entities.AuctionEntity;

public interface AuctionServiceInterface {

    AuctionEntity findEntityById(int id);

    void save(AuctionEntity auctionEntity);

    AuctionEntity findEntityByOrderId(int id);

    void deleteById(int id);
}
