package com.spring.blogSpring.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    //metodo statico para as URIS que nao precisam de autenticacao
    private static final String[] AUTH_LIST = {
        "/",
        "/posts",
        "/posts/{id}"

    };

    //diz que os metodos dentro de AUTH_LIST nao precisam de autenticacao e as outras precisam
    //autentica a formLogin que eh a tela de login
    //autentica a URI do logout
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin() //trocar por um formulario de login que eu vou criar
                .permitAll().and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

    }
    
    //define a autenticacao para o usuario em memoria
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
     auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN");
        
        
    }
    
    
    //permite a autenticacao do bootstrap se ele for baixado e colocado no projeto
    @Override
    public void configure(WebSecurity web)throws Exception {
        
     web.ignoring().antMatchers("/bootstrap/**");
        
        
    }

} 
