package com.training.bloggingsite.contolleres;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Demo {



    @GetMapping("")
    public String getHomepage() {
        return "Object";
    }



}
