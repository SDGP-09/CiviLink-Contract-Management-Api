package com.civilink.civilink_contract_manager.dtos.response;

import com.civilink.civilink_contract_manager.entities.Contract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class ResponseContractAllDto {

    private Contract[] contracts;
}
