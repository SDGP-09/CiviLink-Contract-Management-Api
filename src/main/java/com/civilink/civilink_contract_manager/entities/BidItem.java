package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BidItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //    @ManyToOne
//    @JoinColumn(name = "bid_invitation_id")
//    private BidInvitation bidInvitation;

//    @ManyToOne
//    @JoinColumn(name = "bid_item_id")
//    private BidItem bidItem;

}
