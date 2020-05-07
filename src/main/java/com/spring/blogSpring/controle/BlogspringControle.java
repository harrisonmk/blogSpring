package com.spring.blogSpring.controle;

import com.spring.blogSpring.model.Post;
import com.spring.blogSpring.service.BlogSpringService;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogspringControle {

    @Autowired
    BlogSpringService servico;

    //metodo para renderizar os posts na pagina html com o /posts
    //metodo para listar todas as postagens
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {

        ModelAndView mv = new ModelAndView("posts");

        List<Post> posts = servico.findAll();

        mv.addObject("posts", posts);

        return mv;

    }

    //metodo para buscar um post por ID e renderizar aquele unico post
    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {

        // o postDetails dentro das aspas eh o nome do arquivo html
        ModelAndView mv = new ModelAndView("postDetails");

        Post post = servico.findById(id);

        mv.addObject("post", post);

        return mv;

    }

    //metodo para renderizar o formulario de post
    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm() {

        return "postForm";

    }

    //Metodo para salvar informacoes de posts no banco de dados
    // o @Valid serve para validar os campos com as anotacoes que fiz no model
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes atributes) {

        if (result.hasErrors()) {
            //Mensagem eh um atributo que vai ser chamado no thymeleaf para representar a mensagem de verificacao
            atributes.addFlashAttribute("mensagem","Verifique se os campos obrigatorios foram preenchidos");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        servico.save(post);
        return "redirect:/posts";

    }
    
    
    

}
