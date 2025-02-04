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


public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String date;


    // Corrected ManyToOne relationship to Contractor
    @ManyToOne
    @JoinColumn(name = "contractor_id") // Foreign key to Contractor
    private Contractor contractor;


//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;


}
