package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "bidItems")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidItem {

    @Id
    private String id;
    private String name;
    private String description;
    private String url;
}
