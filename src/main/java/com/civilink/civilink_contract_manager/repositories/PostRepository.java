package com.civilink.civilink_contract_manager.repositories;

import com.civilink.civilink_contract_manager.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
