package com.civilink.civilink_contract_manager.services;

import com.civilink.civilink_contract_manager.dtos.requests.RequestAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestAllBidDto;
import com.civilink.civilink_contract_manager.dtos.requests.RequestBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAddBidInvitationDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseAllBidDto;
import com.civilink.civilink_contract_manager.dtos.response.ResponseBidDto;
import org.springframework.stereotype.Service;


public interface BidService {
    public ResponseBidDto createBid(RequestBidDto requestBidDto);
    public ResponseAddBidInvitationDto addBidInvitation(RequestAddBidInvitationDto requestAddBidInvitationDto);

    public ResponseAllBidDto findAllBids(RequestAllBidDto requestAllBidDto);
}
