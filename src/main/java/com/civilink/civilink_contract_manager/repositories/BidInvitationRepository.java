package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.BidInvitation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BidInvitationRepository extends MongoRepository<BidInvitation, String> {

    @Query("{ 'id': ?0 }")
    Optional<BidInvitation> findById(String id);

    @Query("{ 'id': ?0, $or: [ { 'status': ?1 }, { ?1: null } ] }")
    List<BidInvitation> findByIdAndStatus(String id, String status);

}
