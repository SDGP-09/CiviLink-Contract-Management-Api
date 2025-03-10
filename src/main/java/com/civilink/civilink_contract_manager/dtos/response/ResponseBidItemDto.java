package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.BidItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class ResponseBidItemDto {
    private BidItem bidItem;

    public BidItem getBidItem() {
        return bidItem;
    }

    public void setBidItem(BidItem bidItem) {
        this.bidItem = bidItem;
    }
}
