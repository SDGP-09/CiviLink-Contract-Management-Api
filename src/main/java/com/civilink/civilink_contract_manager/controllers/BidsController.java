package com.civilink.civilink_contract_manager.controllers;


import com.civilink.civilink_contract_manager.dtos.requests.RequestBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidItemDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidItemDto;
import com.civilink.civilink_contract_manager.services.BidInvitationService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bids")
@RequiredArgsConstructor
public class BidsController {

    private final BidInvitationService bidInvitationService;

    @PostMapping("/create-invitation")
    public ResponseEntity<StandardResponse> createBidInvitation(
            @RequestBody RequestBidInvitationDto requestBidInvitationDto
    ) {
        System.out.println("sdfsdfdsf");
        ResponseBidInvitationDto responseBidInvitationDto = bidInvitationService.createBidInvitation(requestBidInvitationDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Bid invitation created",responseBidInvitationDto.getBidInvitation().getId()),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/add-bid-invitation-item")
    public ResponseEntity<StandardResponse> addInvitationItemComponent(
            @RequestBody RequestBidItemDto requestBidItemDto
            ){

        ResponseBidItemDto responseBidItemDto = bidInvitationService.createBidItem(requestBidItemDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Bid item added to the bid",responseBidItemDto.getBidItem().getName()),
                HttpStatus.CREATED
        );
    }
}
