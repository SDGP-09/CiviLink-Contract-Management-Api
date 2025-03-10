package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class RequestAddBidInvitationDto {
    private String bidId;
    private String bidInvitationId;

    public String getBidId() {
        return bidId;
    }

    public void setBidId(String bidId) {
        this.bidId = bidId;
    }

    public String getBidInvitationId() {
        return bidInvitationId;
    }

    public void setBidInvitationId(String bidInvitationId) {
        this.bidInvitationId = bidInvitationId;
    }
}
