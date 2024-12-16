package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("bidResponses")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class BidResponse {
    @Id
    private String id;

    private String date;
    private String url;

    @DBRef
    private List<BidInvitation> bidInvitations;

    @DBRef
    private List<BidItem> bidItems;


}
