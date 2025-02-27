package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseAddBidInvitationDto {
    private long bidId;
    private Bid bid;
    private BidInvitation bidInvitation;
}
