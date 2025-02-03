package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
