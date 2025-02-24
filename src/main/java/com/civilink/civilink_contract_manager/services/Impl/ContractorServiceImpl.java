package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorByIdDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestContractorUpdateDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorAllDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseContractorDto;
import com.civilink.civilink_contract_manager.entities.BidResponse;
import com.civilink.civilink_contract_manager.entities.Contract;
import com.civilink.civilink_contract_manager.entities.Contractor;
import com.civilink.civilink_contract_manager.entities.Post;
import com.civilink.civilink_contract_manager.exception.ContractorNotFoundException;
import com.civilink.civilink_contract_manager.repositories.BidResponsesRepository;
import com.civilink.civilink_contract_manager.repositories.ContractorRepository;
import com.civilink.civilink_contract_manager.repositories.PostRepository;
import com.civilink.civilink_contract_manager.services.ContractorService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractorServiceImpl implements ContractorService {

    private final ContractorRepository contractorRepository;
    private final BidResponsesRepository bidResponsesRepository;
    private final PostRepository postRepository;

    @Override
    public void createContractor(RequestContractorDto requestContractorDto) {
        Contractor contractor = Contractor.builder()
                .name(requestContractorDto.getName())
                .contact(requestContractorDto.getContact())
                .build();

        contractorRepository.save(contractor);
    }





    @Override
    public ResponseContractorDto updateContractor(RequestContractorUpdateDto requestContractorUpdateDto) throws ContractorNotFoundException {
        Contractor contractor = contractorRepository.findById(Long.valueOf(requestContractorUpdateDto.getId())).orElse(null);
        if (contractor == null) throw new ContractorNotFoundException("Contractor not found with the id of: " + requestContractorUpdateDto.getId());

        if (requestContractorUpdateDto.getName() != null) contractor.setName(requestContractorUpdateDto.getName());
        if (requestContractorUpdateDto.getContact() != null) contractor.setContact(requestContractorUpdateDto.getContact());

        if (requestContractorUpdateDto.getBidResponses() != null) {
            List<BidResponse> updatedBidResponses = requestContractorUpdateDto.getBidResponses()
                    .stream()
                    .map(bidResponse -> bidResponsesRepository.save(bidResponse))
                    .toList();


        }

        if (requestContractorUpdateDto.getPosts() != null){
            List<Post> updatedPosts = requestContractorUpdateDto.getPosts()
                    .stream()
                    .map(post -> postRepository.save(post))
                    .toList();

        }

        Contractor updatedContractor = contractorRepository.save(contractor);




        return new ResponseContractorDto(updatedContractor);
    }

    @Override
    public ResponseContractorDto findById(RequestContractorByIdDto requestContractorByIdDto) throws ContractorNotFoundException {
        Contractor contractor = contractorRepository.findById(Long.valueOf(requestContractorByIdDto.getId())).orElse(null);
        if (contractor == null) throw new ContractorNotFoundException("Contractor not found with the id of: " + requestContractorByIdDto.getId());

        return new ResponseContractorDto(contractor);
    }

    @Override
    public ResponseContractorAllDto findAll(RequestContractorDto requestContractorDto) {

        //  If ID is provided, fetch by ID
        if (requestContractorDto.getId() != null) {
            Contractor contractor = contractorRepository.findById(requestContractorDto.getId()).orElse(null);
            if (contractor == null) {
                return new ResponseContractorAllDto(new Contractor[0]); // Return empty array if not found
            }
            return new ResponseContractorAllDto(new Contractor[]{contractor});
        }

        //  If no filters are provided, return all contractors
        if (requestContractorDto.getName() == null && requestContractorDto.getContact() == null) {
            List<Contractor> allContractors = contractorRepository.findAll();
            return new ResponseContractorAllDto(allContractors.toArray(new Contractor[0]));
        }

        //  If filters are provided, search using ExampleMatcher
        Contractor contractor = Contractor.builder()
                .name(requestContractorDto.getName())
                .contact(requestContractorDto.getContact())
                .build();

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING); // Allows partial matches

        Example<Contractor> example = Example.of(contractor, matcher);
        List<Contractor> contractors = contractorRepository.findAll(example);

        return new ResponseContractorAllDto(contractors.toArray(new Contractor[0]));
    }


    @Override
    public void deleteContractor(RequestContractorByIdDto requestContractorByIdDto) throws ContractorNotFoundException {
        Contractor contractor = contractorRepository.findById(Long.valueOf(requestContractorByIdDto.getId())).orElse(null);

        if (contractor ==  null) {
            throw  new ContractorNotFoundException("Contractor not found with the id of: " + requestContractorByIdDto.getId());
        } else {
            contractorRepository.delete(contractor);
        }


    }


}
