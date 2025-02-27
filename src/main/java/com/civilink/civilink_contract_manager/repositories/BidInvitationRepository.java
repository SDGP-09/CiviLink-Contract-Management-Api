package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.BidInvitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface BidInvitationRepository extends JpaRepository<BidInvitation, Long> {


    Optional<BidInvitation> findById(long id);

    @Query("SELECT b FROM BidInvitation b WHERE b.id = :id AND (:status IS NULL OR b.status = :status)")
    List<BidInvitation> findByIdAndStatus(String id, String status);

}
