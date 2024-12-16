package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Bid")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bid {

    @Id
    private String id;
    private String clientName;
    private String activityName;

    @DBRef
    private BidInvitation bidInvitation;

    private List<String> bidResponds;

    @DBRef
    private Project project;
}
