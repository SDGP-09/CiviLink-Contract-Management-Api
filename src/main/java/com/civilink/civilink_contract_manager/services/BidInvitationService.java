package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAllBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidInvitationUpdateDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidItemDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAllBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestDeleteBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidItemDto;


public interface BidInvitationService {
    public ResponseBidInvitationDto createBidInvitation(RequestBidInvitationDto requestBidInvitationDto);
    public ResponseBidItemDto createBidItem(RequestBidItemDto requestBidItemDto);
    public ResponseAllBidInvitationDto sendAllBidInvitation(RequestAllBidInvitationDto requestAllBidInvitationDto);

    public ResponseBidInvitationDto updateBidInvitation(RequestBidInvitationUpdateDto requestBidInvitationUpdateDto);



    public void deleteBidInvitation(RequestDeleteBidInvitationDto requestDeleteBidInvitationDto);
}
