package com.civilink.civilink_contract_manager.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseBidDto {
    private String bidId;
    private String clientName;
    private String projectName;
    private String ActivityName;
}
