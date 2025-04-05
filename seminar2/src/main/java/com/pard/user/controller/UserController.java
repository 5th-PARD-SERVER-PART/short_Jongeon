package com.pard.user.controller;

import com.pard.user.dto.UserDto;
import com.pard.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "저장완료!!";
    }

    @GetMapping("/{studentID}")
    public UserDto findByID(@PathVariable Long studentID){
        return userService.findByID(studentID);
    }

    @PatchMapping("/{studentID}")
    public String updateByID(@PathVariable Long studentID, @RequestBody UserDto userDto) {
        userService.updateByID(studentID, userDto);
        return "수정완료~";
    }

    @DeleteMapping("/{studentID}")
    public String delete(@PathVariable Long studentID) {
        userService.delete(studentID);
        return "삭제완료~~~";
    }

    @GetMapping("")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

}
