package com.civilink.civilink_contract_manager.dtos.requests;

import com.civilink.civilink_contract_manager.entities.BidResponse;
import com.civilink.civilink_contract_manager.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

@Builder

public class RequestContractorUpdateDto {
    private Long id;
    private String name;
    private String contact;
    private List<BidResponse> bidResponses;

    private List<Post> posts;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<BidResponse> getBidResponses() {
        return bidResponses;
    }

    public void setBidResponses(List<BidResponse> bidResponses) {
        this.bidResponses = bidResponses;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
