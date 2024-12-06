package com.civilink.civilink_contract_manager.dtos.requests;

import com.civilink.civilink_contract_manager.entities.BidItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestBidInvitationUpdateDto {
    private String id;
    private String title;
    private String description;
    private String createdBy;
    private String status;
    private List<BidItem> bidItems;

}
