package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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

//    @ManyToOne
//    @JoinColumn(name = "project_id")
//    private  Project project;

}
