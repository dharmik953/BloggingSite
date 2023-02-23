package com.training.bloggingsite.contolleres;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Demo {



    @RequestMapping(value = "/welcome")
    public String getHomepage() {
        return "welcome";
    }



}
