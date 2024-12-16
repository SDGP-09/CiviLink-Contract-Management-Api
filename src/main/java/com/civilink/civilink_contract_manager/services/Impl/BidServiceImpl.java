package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidDto;
import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.BidInvitationRepository;
import com.civilink.civilink_contract_manager.repositories.BidRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
import com.civilink.civilink_contract_manager.services.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidInvitationRepository bidInvitationRepository;

    private final BidRepository bidRepository;

    private final ProjectRepository projectRepository;

    @Override
    public ResponseBidDto createBid(RequestBidDto requestBidDto) {

        Project project = projectRepository.findById(requestBidDto.getProjectId()).get();



        Bid bid = Bid.builder()
                .id(requestBidDto.getId())
                .clientName(requestBidDto.getClientName())
                .bidResponds(new ArrayList<>())
                .activityName(requestBidDto.getActivityName())
                .bidInvitation(null)
                .project(project)
                .build();

        bidRepository.save(bid);

        project.setBid(bid);
        projectRepository.save(project);

        return new ResponseBidDto(bid.getId(),
                bid.getClientName(),
                bid.getProject().getProjectName(),
                bid.getActivityName());
    }

    @Override
    public ResponseAddBidInvitationDto addBidInvitation(RequestAddBidInvitationDto requestAddBidInvitationDto) {
        BidInvitation invitation = bidInvitationRepository.findById(requestAddBidInvitationDto.getBidInvitationId()).get();

        Bid bid = bidRepository.findById(requestAddBidInvitationDto.getBidId()).get();

        bid.setBidInvitation(invitation);
        bidRepository.save(bid);

        return new ResponseAddBidInvitationDto(bid.getId(), bid,invitation);
    }

}
