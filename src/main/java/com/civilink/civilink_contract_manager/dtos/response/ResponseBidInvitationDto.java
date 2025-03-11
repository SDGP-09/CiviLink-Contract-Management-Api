package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.BidInvitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
public class ResponseBidInvitationDto {
    private BidInvitation bidInvitation;

    public BidInvitation getBidInvitation() {
        return bidInvitation;
    }

    public void setBidInvitation(BidInvitation bidInvitation) {
        this.bidInvitation = bidInvitation;
    }
}
