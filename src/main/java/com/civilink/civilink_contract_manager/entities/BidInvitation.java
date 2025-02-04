package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
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

    @OneToMany(mappedBy = "bidInvitation") // This assumes BidItem has a field bidInvitation
    private List<BidItem> bidItems = new ArrayList<>(); // Initialize the list to prevent NullPointerException

    @ManyToOne
    @JoinColumn(name = "bid_invitation_id")
    private BidInvitation bidInvitation;



}
