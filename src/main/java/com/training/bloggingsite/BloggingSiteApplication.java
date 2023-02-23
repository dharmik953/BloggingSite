package com.training.bloggingsite;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BloggingSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloggingSiteApplication.class, args);
    }

    // Used for creating the Bean of ModelMapper class.
    @Bean
    public ModelMapper getModelMapperInstance(){
        return new ModelMapper();
    }


}
