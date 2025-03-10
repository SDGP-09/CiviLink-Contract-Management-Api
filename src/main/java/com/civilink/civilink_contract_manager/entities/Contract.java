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

public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String contractDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    // Link Contract to Project
//    @ManyToOne
//    @JoinColumn(name = "project_id") // Foreign key reference
//    private Project project;
//
//
//    //Contract should store a List of ContractItems
//    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ContractItems> contractItems; // Reference contract items instead

//    @ManyToOne
//    @JoinColumn(name = "contract_id")
//    private Contract contract;
}
