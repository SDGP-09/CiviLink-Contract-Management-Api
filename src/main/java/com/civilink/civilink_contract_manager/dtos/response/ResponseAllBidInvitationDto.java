package com.civilink.civilink_contract_manager.dtos.response;


import com.civilink.civilink_contract_manager.entities.BidInvitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


public class ResponseAllBidInvitationDto {
    private BidInvitation[] bidInvitations;

    public BidInvitation[] getBidInvitations() {
        return bidInvitations;
    }

    public void setBidInvitations(BidInvitation[] bidInvitations) {
        this.bidInvitations = bidInvitations;
    }
}
