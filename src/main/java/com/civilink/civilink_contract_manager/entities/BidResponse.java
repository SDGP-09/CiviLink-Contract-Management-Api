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
@Data
@Builder


public class BidResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String url;

    // Corrected ManyToOne relationship to Contractor
    @ManyToOne
    @JoinColumn(name = "contractor_id") // Foreign key to Contractor
    private Contractor contractor;


//    @OneToOne
//    @JoinColumn(name = "bid_response_id")
//    private BidResponse bidResponse;


}
