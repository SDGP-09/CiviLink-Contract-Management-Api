package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
//    List<Bid> findByBidId(String bidId);
//    List<Bid> findByClientName(String ClientName);
//    List<Bid> findByProjectName(String projectName);
//    List<Bid> findByActivityName(String activityName);

}
