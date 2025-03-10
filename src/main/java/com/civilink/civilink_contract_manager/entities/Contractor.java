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
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String contact;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    // Add OneToMany relationship with BidResponse
//    @OneToMany(mappedBy = "contractor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<BidResponse> bidResponses;
//
//    // Add OneToMany relationship with Post
//    @OneToMany(mappedBy = "contractor", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Post> posts;


//    @ManyToOne
//    @JoinColumn(name = "contractor_id")
//    private Contractor contractor;


}
