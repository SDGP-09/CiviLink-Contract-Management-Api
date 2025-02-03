package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("contract")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Contract {
    @Id
    private String id;

    @DBRef
    private Project project;

    @DBRef
    private List<ContractItems> contracts;

    private String description;
    private String contractDate;
}
