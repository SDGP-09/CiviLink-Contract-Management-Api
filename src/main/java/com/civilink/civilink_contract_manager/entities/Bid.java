package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String clientName;
    private String activityName;


    @OneToOne
    @JoinColumn(name = "bid_id")
    private Bid bid;

}
