package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestAllBidDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAllBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidDto;
import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import com.civilink.civilink_contract_manager.repositories.BidInvitationRepository;
import com.civilink.civilink_contract_manager.repositories.BidRepository;
import com.civilink.civilink_contract_manager.services.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public ResponseAllBidDto findAllBids(RequestAllBidDto requestAllBidDto) {



        Bid bid = new Bid();
        bid.setBidId(requestAllBidDto.getBidId());
        bid.setClientName(requestAllBidDto.getClientName());
        bid.setProjectName(requestAllBidDto.getProjectName());
        bid.setActivityName(requestAllBidDto.getActivityName());

        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

        Example<Bid> example = Example.of(bid, matcher);
        List<Bid> bids = bidRepository.findAll(example);
        Bid[] toReturn = new Bid[bids.size()];
        toReturn = bids.toArray(toReturn);
        return new ResponseAllBidDto(toReturn);
    }

}