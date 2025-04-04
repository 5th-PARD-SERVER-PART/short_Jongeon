package com.pard.hw2.user.repository;

import com.pard.hw2.user.dto.TheaterDto;
import com.pard.hw2.user.entity.User;
import com.pard.hw2.user.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<String, User> db = new HashMap<>();

    public void save(UserDto userDto){
        User user = User.builder()
                .movieName(userDto.getMovieName())
                .screenTime(userDto.getScreenTime())
                .theater(userDto.getTheater())
                .build();
        db.put(userDto.getMovieName(), user);
    }

    public List<UserDto> findAll(){
        return db.values().stream()
                .map(user -> UserDto.builder()
                        .movieName(user.getMovieName())
                        .theater(user.getTheater())
                        .screenTime(user.getScreenTime())
                        .build()).toList();
    }

    public List<UserDto> findMoviesByTheater(String theater) {
        return db.values().stream()
                .filter(user -> theater.equals(user.getTheater()))
                .map(user -> UserDto.builder()
                        .movieName(user.getMovieName())
                        .theater(user.getTheater())
                        .screenTime(user.getScreenTime())
                        .build()).toList();
    }

    public UserDto findMovieByNameAndTheater(String movieName, String theater) {
        return   db.values().stream()
                .filter(user -> theater.equals(user.getTheater()) && movieName.equals(user.getMovieName()))
                .map(user -> UserDto.builder()
                        .movieName(user.getMovieName())
                        .theater(user.getTheater())
                        .screenTime(user.getScreenTime())
                        .build())
                .findFirst()
                .orElse(UserDto.builder()
                        .movieName("그런영화없음")
                        .theater("그런극장없음")
                        .screenTime(0)
                        .build());
    }

    public void updateTheaterByMovieName(String movieName, TheaterDto theaterDto){
        User user = db.get(movieName);
        user.updateTheater(theaterDto.getTheater());
    }

    public void delete(String movieName) {
        db.remove(movieName);
    }
}
