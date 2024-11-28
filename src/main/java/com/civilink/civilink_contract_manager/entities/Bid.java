package com.civilink.civilink_contract_manager.entities;

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
    private String bidId;
    private String clientName;
    private String projectName;
    private String ActivityName;

    @DBRef
    private BidInvitation bidInvitation;

    private List<String> bidResponds;
}
