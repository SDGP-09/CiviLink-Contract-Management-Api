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

public class Client {
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

    //    // This is the list of projects associated with this client
//    @OneToMany(mappedBy = "client")
//    private List<Project> projectList;
//
//    // Recursive reference, if you need it for hierarchical structure
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client; // Parent client (optional, only if needed)




}
