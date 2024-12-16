package com.civilink.civilink_contract_manager.dtos.requests;

import com.civilink.civilink_contract_manager.entities.BidResponse;
import com.civilink.civilink_contract_manager.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class RequestContractorUpdateDto {
    private String id;
    private String name;
    private String contact;
    private List<BidResponse> bidResponses;

    private List<Post> posts;

}
