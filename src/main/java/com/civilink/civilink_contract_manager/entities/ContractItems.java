package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContractItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String url;
    private String description;

}
