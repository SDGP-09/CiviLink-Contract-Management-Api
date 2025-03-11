package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class ResponseAddBidInvitationDto {
    private long bidId;
    private Bid bid;
    private BidInvitation bidInvitation;

    public long getBidId() {
        return bidId;
    }

    public void setBidId(long bidId) {
        this.bidId = bidId;
    }

    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    public BidInvitation getBidInvitation() {
        return bidInvitation;
    }

    public void setBidInvitation(BidInvitation bidInvitation) {
        this.bidInvitation = bidInvitation;
    }
}
