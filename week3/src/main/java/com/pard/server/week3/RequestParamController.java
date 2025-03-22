package com.pard.server.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public class RequestParamController {
    @RequestMapping("/v1")
    public String param1(@RequestParam("name") String myName, @RequestParam("age") int myAge){
        return "RequestParam 1번 : " + myName + " 나이 " + myAge;
    }

    @RequestMapping("/v2")
    public String param2(@RequestParam String name,@RequestParam int age){
        return "RequestParam 2번 : "+name + " 나이 "+ age;
    }

    @RequestMapping("/v3")
    public String param3(String name,int age){
        return "RequestParam 3번 : " + name + " 나이 " + age;
    }

    @RequestMapping("/v4")
    public String param4(@RequestParam String name,@RequestParam(required = false) Integer age){
        if (age == null) {
            return "Request param 4 : " + name + " age : Not provided";
        }
        return "Request param 4 : " + name + " age : " + age;
    }

    @RequestMapping("/v5")
    public String param5(
            @RequestParam(required = true,defaultValue = "파드") String name
            ,@RequestParam(required = false,defaultValue = "-1") Integer age){
        return "RequestParam 5번 : " + name + " 나이 "+ age;
    }

    @RequestMapping("/v6")
    public String param6(@RequestParam Map<String, Objects> map){
        return "RequestParam 6번 : "+ map.get("name") + map.get("age");
    }
}
