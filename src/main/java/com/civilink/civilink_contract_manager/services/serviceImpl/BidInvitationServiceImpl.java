package com.civilink.civilink_contract_manager.services.serviceImpl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidItemDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidItemDto;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import com.civilink.civilink_contract_manager.entities.BidItem;
import com.civilink.civilink_contract_manager.repositories.BidInvitationRepository;
import com.civilink.civilink_contract_manager.repositories.BidItemRepository;
import com.civilink.civilink_contract_manager.services.BidInvitationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BidInvitationServiceImpl implements BidInvitationService {

    private final BidInvitationRepository bidInvitationRepository;
    private final BidItemRepository bidItemRepository;

    @Override
    public ResponseBidInvitationDto createBidInvitation(RequestBidInvitationDto requestBidInvitationDto) {

        BidInvitation bidInvitation = BidInvitation.builder()
                .id(requestBidInvitationDto.getId())
                .title(requestBidInvitationDto.getTitle())
                .status(requestBidInvitationDto.getStatus())
                .bidItems(new ArrayList<>())
                .createdBy(requestBidInvitationDto.getCreatedBy())
                .description(requestBidInvitationDto.getDescription())
                .build();
        bidInvitationRepository.save(bidInvitation);


        return new ResponseBidInvitationDto(bidInvitation);
    }

    @Override
    public ResponseBidItemDto createBidItem(RequestBidItemDto requestBidItemDto) {

        BidInvitation invitation = bidInvitationRepository.findById("BID001").get();

        BidItem bidItem = BidItem.builder().id(requestBidItemDto.getId())
                .name(requestBidItemDto.getName())
                .url(requestBidItemDto.getUrl())
                .build();

        invitation.getBidItems().add(bidItem);

        bidItemRepository.save(bidItem);
        bidInvitationRepository.save(invitation);

        return new ResponseBidItemDto(bidItem);


    }
}
