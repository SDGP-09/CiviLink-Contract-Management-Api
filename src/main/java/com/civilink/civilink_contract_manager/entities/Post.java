package com.civilink.civilink_contract_manager.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder


public class Post {

    @Id
    private String id;
    private String title;
    private String date;




}
