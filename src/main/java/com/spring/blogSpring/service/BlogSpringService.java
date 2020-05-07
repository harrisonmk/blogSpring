package com.spring.blogSpring.service;

import com.spring.blogSpring.model.Post;
import java.util.List;

public interface BlogSpringService {

    List<Post> findAll(); //retorna uma lista de post

    Post findById(long id);// retorna um unico post

    Post save(Post post);//salva um post no banco de dados

}
