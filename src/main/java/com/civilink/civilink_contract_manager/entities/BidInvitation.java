package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("bidInvitations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidInvitation {
    @Id
    private String id;
    private String title;
    private String description;
    private String createdBy;
    private String status;

    @DBRef
    private List<BidItem> bidItems;


}
