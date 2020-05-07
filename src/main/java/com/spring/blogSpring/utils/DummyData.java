package com.spring.blogSpring.utils;

import com.spring.blogSpring.model.Post;
import com.spring.blogSpring.repository.BlogSpringRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DummyData {

    @Autowired
    BlogSpringRepository blogSpringRepository;

    //caso nao esteja comentado o @PostConstruct a cada execucao do projeto ele criara e salvara tudo o que esta dentro do metodo abaixo
    //@PostConstruct 
    public void savePost() {

        List<Post> postlist = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("harrison mitchell");
        post1.setData(LocalDate.now());
        post1.setTitulo("JSF");
        post1.setTexto("o jsf esta sendo usado mais em sistemas legados");

        Post post2 = new Post();
        post2.setAutor("naruto uzumki");
        post2.setData(LocalDate.now());
        post2.setTitulo("Spring boot");
        post2.setTexto("Spring boot crescendo em aplicacoes web");

        postlist.add(post1);
        postlist.add(post2);

        
        for(Post post :postlist){
            Post postSaved = blogSpringRepository.save(post);
            System.out.println(postSaved.getId());
        }
        
    }

}
