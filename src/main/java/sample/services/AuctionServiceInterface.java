package sample.services;

public interface AuctionServiceInterface {

    AuctionEntity findEntityById(int id);

    void save(AuctionEntity auctionEntity);

    AuctionEntity findEntityByOrderId(int id);

    void deleteById(int id);
}
