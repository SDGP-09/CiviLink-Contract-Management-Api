package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("clients")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client {
    @Id
    private String id;
    private String name;
    private String contact;

    @DBRef
    private List<Project> projectList;
}
