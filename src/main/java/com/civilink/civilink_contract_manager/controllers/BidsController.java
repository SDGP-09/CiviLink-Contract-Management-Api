package com.civilink.civilink_contract_manager.controllers;


import com.civilink.civilink_contract_manager.dtos.requests.*;
import com.civilink.civilink_contract_manager.dtos.response.*;
import com.civilink.civilink_contract_manager.services.BidInvitationService;
import com.civilink.civilink_contract_manager.services.BidService;
import com.civilink.civilink_contract_manager.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bids")
@RequiredArgsConstructor
public class BidsController {

    private final BidInvitationService bidInvitationService;
    private final BidService bidService;

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

    @PostMapping("/new-bid")
    public ResponseEntity<StandardResponse> makeNewBid(
            @RequestBody RequestBidDto requestBidDto
    ){
        ResponseBidDto responseBidDto=bidService.createBid(requestBidDto);

        return new ResponseEntity<>(
                new StandardResponse(201,"Bid created", responseBidDto),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/add-bid-invitation-to-bid")
    public ResponseEntity<StandardResponse> addBidInvitationToBid(
            @RequestBody RequestAddBidInvitationDto requestAddBidInvitationDto
    ){
        ResponseAddBidInvitationDto responseAddBidInvitationDto=bidService.addBidInvitation(requestAddBidInvitationDto);

        return new ResponseEntity<>(
                new StandardResponse(200,"Bid invitation added",responseAddBidInvitationDto),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/search-bid-invitation")
    public ResponseEntity<StandardResponse> searchInvitation(
            @RequestBody RequestAllBidInvitationDto requestAllBidInvitationDto
            ){
        ResponseAllBidInvitationDto responseAllBidInvitationDto = bidInvitationService.sendAllBidInvitation(requestAllBidInvitationDto);


        return new ResponseEntity<>(
                new StandardResponse(200,"{ADD A MEANINGFUL MESSAGE HERE}",responseAllBidInvitationDto),
                HttpStatus.CREATED //get clarification whether this is correct or wrong ?

        );
    }

    @GetMapping("/search-bid")
    public ResponseEntity<StandardResponse>  searchBid(
            @RequestBody RequestAllBidDto requestAllBidDto
    ){
        ResponseAllBidDto responseAllBidDto1 = bidService.findAllBids(requestAllBidDto);

        return new ResponseEntity<>(
                new StandardResponse(200,"{ADD A MEANINGFUL MESSAGE HERE}",responseAllBidDto1),
                HttpStatus.CREATED//get clarification whether this is correct or wrong ?
        );
    }

    @PatchMapping("/update-bid-invitation")
    public ResponseEntity<StandardResponse> updateBidInvitation(
            @RequestBody RequestBidInvitationUpdateDto requestBidInvitationUpdateDto
    ){
        ResponseBidInvitationDto responseBidInvitationDto =
                bidInvitationService.updateBidInvitation(requestBidInvitationUpdateDto);
//        return null;
        return new ResponseEntity<>(
                new StandardResponse(200,"{ADD A MEANINGFUL MESSAGE HERE}",requestBidInvitationUpdateDto),
                HttpStatus.CREATED//get clarification whether this is correct or wrong ?
        );
    }







}
