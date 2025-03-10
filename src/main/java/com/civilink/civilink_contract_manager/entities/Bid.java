package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String clientName;
    private String activityName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    //    @ManyToOne
//    @JoinColumn(name = "project_id")  // Foreign key column for the relationship
//    private Project project;  // This defines the relationship between Bid and Project
//
//    // Add the relationship to BidInvitation
//    @ManyToOne
//    @JoinColumn(name = "bid_invitation_id") // Foreign key column for the relationship
//    private BidInvitation bidInvitation;  // This defines the relationship between Bid and BidInvitation
//
//    // List to hold BidResponse objects
//    @OneToMany(mappedBy = "bid")
//    private List<BidResponse> bidResponds = new ArrayList<>();  // Proper initialization


//    @OneToOne
//    @JoinColumn(name = "bid_id")
//    private Bid bid;

}
