package com.training.bloggingsite.contolleres;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a/")
public class Demo {



    @GetMapping("welcome")
    public String getHomepage() {
        return "Object";
    }



}
