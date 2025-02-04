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

public class Consultant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String specializations;

    @OneToMany(mappedBy = "consultant")  // This indicates a consultant can have multiple projects
    private List<Project> projects;  // List of projects for this consultant


//    @ManyToOne
//    @JoinColumn(name = "consultant_id")
//    private Consultant consultant;

}
