package com.civilink.civilink_contract_manager.services.Impl;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestAllBidDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAllBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidDto;
import com.civilink.civilink_contract_manager.entities.Bid;
import com.civilink.civilink_contract_manager.entities.BidInvitation;
import com.civilink.civilink_contract_manager.entities.Project;
import com.civilink.civilink_contract_manager.repositories.BidInvitationRepository;
import com.civilink.civilink_contract_manager.repositories.BidRepository;
import com.civilink.civilink_contract_manager.repositories.ProjectRepository;
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

    private final ProjectRepository projectRepository;

    @Override
    public ResponseBidDto createBid(RequestBidDto requestBidDto) {

        Project project = projectRepository.findById(Long.valueOf(requestBidDto.getProjectId())).get();



        Bid bid = Bid.builder()
                .id(Long.parseLong(requestBidDto.getId()))
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
        BidInvitation invitation = bidInvitationRepository.findById(Long.parseLong(requestAddBidInvitationDto.getBidInvitationId())).get();

        Bid bid = bidRepository.findById(Long.valueOf(requestAddBidInvitationDto.getBidId())).get();

        bid.setBidInvitation(invitation);
        bidRepository.save(bid);

        return new ResponseAddBidInvitationDto(bid.getId(), bid,invitation);
    }

    @Override
    public ResponseAllBidDto findAllBids(RequestAllBidDto requestAllBidDto) {



        Bid bid = new Bid();
        bid.setId(Long.parseLong(requestAllBidDto.getBidId()));
        bid.setClientName(requestAllBidDto.getClientName());
        bid.setActivityName(requestAllBidDto.getActivityName());

        // Get the associated Project object
        Project project = bid.getProject();  // Access the Project object from Bid
        if (project != null) {
            project.setProjectName(requestAllBidDto.getProjectName());  // Set the projectName on the Project object
        }
        // Now set the project object on the Bid
        bid.setProject(project);


        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();

        Example<Bid> example = Example.of(bid, matcher);
        List<Bid> bids = bidRepository.findAll(example);
        Bid[] toReturn = new Bid[bids.size()];
        toReturn = bids.toArray(toReturn);
        return new ResponseAllBidDto(toReturn);
    }

}
