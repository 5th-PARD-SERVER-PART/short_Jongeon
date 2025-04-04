package com.pard.hw2.user.controller;

import com.pard.hw2.user.dto.TheaterDto;
import com.pard.hw2.user.dto.UserDto;
import com.pard.hw2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public String save(@RequestBody UserDto userDto){
        userService.save(userDto);
        return "저장완료!!!";
    }

    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{theater}")
    public List<UserDto> findMoviesByTheater(@PathVariable String theater){
        return userService.findMoviesByTheater(theater);
    }

    @GetMapping("/find")
    public UserDto findMovieByNameAndTheater(@RequestParam String movieName, @RequestParam String theater){
        return userService.findMovieByNameAndTheater(movieName, theater);
    }

    @PatchMapping("/{movieName}")
    public String updateTheaterByMovieName(@PathVariable String movieName, @RequestBody TheaterDto theaterDto){
        userService.updateTheaterByMovieName(movieName, theaterDto);
        return "업데이트 완료!!";
    }

    @DeleteMapping("/{movieName}")
    public String delete(@PathVariable String movieName){
        userService.delete(movieName);
        return "삭제완료~~";
    }
}
