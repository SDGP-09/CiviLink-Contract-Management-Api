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

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String contractDate;


    // Link Contract to Project
    @ManyToOne
    @JoinColumn(name = "project_id") // Foreign key reference
    private Project project;


    //Contract should store a List of ContractItems
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContractItems> contractItems; // Reference contract items instead

//    @ManyToOne
//    @JoinColumn(name = "contract_id")
//    private Contract contract;
}
