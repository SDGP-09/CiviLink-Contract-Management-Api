package com.civilink.civilink_contract_manager.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class RequestClientUpdateDTO {

    private String id;
    private String name;
    private String contact;


}
