package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractItemsUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractItemsDto;
import com.civilink.civilink_contract_manager.entities.Contract;
import com.civilink.civilink_contract_manager.entities.ContractItems;
import com.civilink.civilink_contract_manager.exception.ContractItemsNotFoundException;
import com.civilink.civilink_contract_manager.repositories.ContractItemsRepository;
import com.civilink.civilink_contract_manager.repositories.ContractRepository;
import com.civilink.civilink_contract_manager.services.ContractItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractItemsServiceImpl implements ContractItemsService {

    private final ContractItemsRepository contractItemsRepository;
    private final ContractRepository contractRepository;

    @Override
    public void createContractItems(RequestContractItemsDto contractItemDto) {

        Contract contract = contractRepository.findById(Integer.valueOf(contractItemDto.getContractId())).get();

        ContractItems contractItems = ContractItems.builder()
                .id(Long.parseLong(contractItemDto.getId()))
                .description(contractItemDto.getDescription())
                .url(contractItemDto.getUrl())
                .contract(contract)
                .build();

        contractItemsRepository.save(contractItems);

        contract.getContractItems().add(contractItems);
        contractRepository.save(contract);
    }


    @Override
    public ResponseContractItemsDto updateContractItems(RequestContractItemsUpdateDto request) throws ContractItemsNotFoundException {
        ContractItems contractItems = contractItemsRepository.findById(request.getId()).orElse(null);

        if (contractItems == null) {
            throw new ContractItemsNotFoundException("ContractItems not found with the id of: " + request.getId());
        }


        if (request.getUrl() != null) contractItems.setUrl(request.getUrl());
        if (request.getDescription() != null) contractItems.setDescription(request.getDescription());


        if (request.getContract() != null) {

            Contract updatedContract = contractRepository.save(request.getContract());
            contractItems.setContract(updatedContract);
        }

        ContractItems updatedContractItems = contractItemsRepository.save(contractItems);
        return new ResponseContractItemsDto(updatedContractItems);
    }

    @Override
    public ResponseContractItemsDto findById(RequestContractItemsByIdDto request) throws ContractItemsNotFoundException {
        ContractItems contractItems = contractItemsRepository.findById(request.getId()).orElse(null);
        if (contractItems == null) {
            throw new ContractItemsNotFoundException("ContractItems not found with the id of: " + request.getId());
        }
        return new ResponseContractItemsDto(contractItems);
    }

    @Override
    public ResponseContractItemsAllDto findAll(RequestContractItemsDto requestDto) {
        if (requestDto.getId() != null) {
            ContractItems contractItems = contractItemsRepository.findById(requestDto.getId()).orElse(null);
            ContractItems[] array = {contractItems};
            return new ResponseContractItemsAllDto(array);
        } else {

            ContractItems exampleItems = ContractItems.builder()
                    .url(requestDto.getUrl())
                    .description(requestDto.getDescription())
                    .build();

            ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
            Example<ContractItems> example = Example.of(exampleItems, matcher);

            List<ContractItems> itemsList = contractItemsRepository.findAll(example);
            ContractItems[] toReturn = new ContractItems[itemsList.size()];
            toReturn = itemsList.toArray(toReturn);

            return new ResponseContractItemsAllDto(toReturn);
        }
    }

    @Override
    public void deleteContractItems(RequestContractItemsByIdDto request) throws ContractItemsNotFoundException {
        ContractItems contractItems = contractItemsRepository.findById(request.getId()).orElse(null);
        if (contractItems == null) {
            throw new ContractItemsNotFoundException("ContractItems not found with the id of: " + request.getId());
        }
        contractItemsRepository.delete(contractItems);
    }
}








