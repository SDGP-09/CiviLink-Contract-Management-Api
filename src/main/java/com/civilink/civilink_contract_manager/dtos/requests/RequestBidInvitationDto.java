package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBidInvitationDto {
    private String id;
    private String title;
    private String description;
    private String createdBy;
    private String status;
}
