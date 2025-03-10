package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Bid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

public class ResponseAllBidDto {
    private Bid[] bids;

    public Bid[] getBids() {
        return bids;
    }

    public void setBids(Bid[] bids) {
        this.bids = bids;
    }
}
