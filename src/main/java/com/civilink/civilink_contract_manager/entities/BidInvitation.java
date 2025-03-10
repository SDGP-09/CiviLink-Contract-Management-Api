package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidInvitation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String createdBy;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    //    @OneToMany(mappedBy = "bidInvitation") // This assumes BidItem has a field bidInvitation
//    private List<BidItem> bidItems = new ArrayList<>(); // Initialize the list to prevent NullPointerException
//
//    @ManyToOne
//    @JoinColumn(name = "bid_invitation_id")
//    private BidInvitation bidInvitation;



}
