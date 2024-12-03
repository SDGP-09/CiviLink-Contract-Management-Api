package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("contract_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ContractItems {

    @Id
    private String id;
    private String url;
    private String description;

    @DBRef
    private Contract contract;
}
