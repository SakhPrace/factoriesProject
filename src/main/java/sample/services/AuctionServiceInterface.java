package sample.services;

import sample.entities.AuctionEntity;

import java.util.Optional;

public interface AuctionServiceInterface {

    AuctionEntity findEntityById(Integer id);

    void save(AuctionEntity auctionEntity);

    AuctionEntity findEntityByName(String name);
}
