package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Consultant")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Consultant {
    @Id
    private String id;
    private String name;
    private String specializations;

    @DBRef
    private List<Project> projects;

}
