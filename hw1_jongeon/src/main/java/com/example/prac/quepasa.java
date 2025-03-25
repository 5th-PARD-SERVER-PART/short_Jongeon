package com.example.prac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class quepasa {
    @RequestMapping("")
    public String quepasa(){
        return "quepasa";
    }
}
