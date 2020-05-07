
package com.spring.blogSpring.repository;

import com.spring.blogSpring.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BlogSpringRepository extends JpaRepository<Post,Long> {
    
}
