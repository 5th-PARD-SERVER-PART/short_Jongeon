package com.pard.server.week3;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RestMethodController {
    @GetMapping("")
    public String getUsers(){
        return " Get Method controller";
    }

    @PostMapping("")
    public String postUsers(){
        return "Add users to DB";
    }

    @GetMapping("/{userId}")
    public String getUsersById(@PathVariable Long userId){
        return userId  + "# user id updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return userId + "# user id deleted";
    }
}

