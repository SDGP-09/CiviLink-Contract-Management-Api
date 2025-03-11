package com.civilink.civilink_contract_manager.dtos.requests;

import com.civilink.civilink_contract_manager.entities.BidItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor


public class RequestBidInvitationUpdateDto {
    private String id;
    private String title;
    private String description;
    private String createdBy;
    private String status;
    private List<BidItem> bidItems;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BidItem> getBidItems() {
        return bidItems;
    }

    public void setBidItems(List<BidItem> bidItems) {
        this.bidItems = bidItems;
    }
}
