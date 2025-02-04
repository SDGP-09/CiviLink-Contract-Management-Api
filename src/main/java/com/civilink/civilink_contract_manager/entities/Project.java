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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int projectNumber;
    private String projectName;
    private String projectDescription;
    private String projectStartDate;
    private String projectEndDate;
    private String projectStatus;
    private String projectCategory;

    // Relationship to Bid
    @ManyToOne
    @JoinColumn(name = "bid_id")  // Assuming each project is linked to one bid
    private Bid bid;

    @ManyToOne
    @JoinColumn(name = "consultant_id")  // Foreign key to link Project with Consultant
    private Consultant consultant;  // Each project can be linked to one consultant

    // A Project can have multiple Contracts
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contract> contracts;

    //Add ManyToOne relationship to Client
    @ManyToOne
    @JoinColumn(name = "client_id") // Foreign key reference
    private Client client;



}
