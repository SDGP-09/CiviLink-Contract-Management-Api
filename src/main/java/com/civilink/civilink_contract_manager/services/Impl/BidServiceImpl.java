package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidDto;
import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import com.civilink.civilink_contract_manager.repositories.BidInvitationRepository;
import com.civilink.civilink_contract_manager.repositories.BidRepository;
import com.civilink.civilink_contract_manager.services.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidInvitationRepository bidInvitationRepository;

    private final BidRepository bidRepository;

    @Override
    public ResponseBidDto createBid(RequestBidDto requestBidDto) {
        Bid bid = Bid.builder()
                .bidId(requestBidDto.getBidId())
                .clientName(requestBidDto.getClientName())
                .bidResponds(new ArrayList<>())
                .ActivityName(requestBidDto.getActivityName())
                .bidInvitation(null)
                .projectName(requestBidDto.getProjectName())
                .build();

        bidRepository.save(bid);

        return new ResponseBidDto(bid.getBidId(),
                bid.getClientName(),
                bid.getProjectName(),
                bid.getActivityName());
    }

    @Override
    public ResponseAddBidInvitationDto addBidInvitation(RequestAddBidInvitationDto requestAddBidInvitationDto) {
        BidInvitation invitation = bidInvitationRepository.findById(requestAddBidInvitationDto.getBidInvitationId()).get();

        Bid bid = bidRepository.findById(requestAddBidInvitationDto.getBidId()).get();

        bid.setBidInvitation(invitation);
        bidRepository.save(bid);

        return new ResponseAddBidInvitationDto(bid.getBidId(), bid,invitation);
    }

}
