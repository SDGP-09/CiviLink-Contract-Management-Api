package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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


}
