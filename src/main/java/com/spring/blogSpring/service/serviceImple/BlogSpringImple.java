
package com.spring.blogSpring.service.serviceImple;

import com.spring.blogSpring.model.Post;
import com.spring.blogSpring.repository.BlogSpringRepository;
import com.spring.blogSpring.service.BlogSpringService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogSpringImple implements BlogSpringService {
    
    //faz o ponto de injecao
    //cria a instancia do BlogSpringRepository  automaticamente
    @Autowired
    BlogSpringRepository blogSpringRepository;

    @Override
    public List<Post> findAll() {
       
        return blogSpringRepository.findAll();
    }

    @Override
    public Post findById(long id) {
       
        return blogSpringRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        
        return blogSpringRepository.save(post);
    }

    
    
}
