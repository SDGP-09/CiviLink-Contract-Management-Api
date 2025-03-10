package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor

@Builder


public class BidResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Corrected ManyToOne relationship to Contractor
//    @ManyToOne
//    @JoinColumn(name = "contractor_id") // Foreign key to Contractor
//    private Contractor contractor;
//
//
//    // Add ManyToOne mapping to Bid
//    @ManyToOne
//    @JoinColumn(name = "bid_id") // Foreign key to Bid
//    private Bid bid;


//    @OneToOne
//    @JoinColumn(name = "bid_response_id")
//    private BidResponse bidResponse;


}
