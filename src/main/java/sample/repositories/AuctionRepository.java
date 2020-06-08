package sample.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends CrudRepository<AuctionEntity, Integer> {
    @Query("SELECT e FROM AuctionEntity e WHERE e.idOrder = :orderId")
    AuctionEntity getAuctionEntityByOrderId(@Param("orderId") int orderId);
}
