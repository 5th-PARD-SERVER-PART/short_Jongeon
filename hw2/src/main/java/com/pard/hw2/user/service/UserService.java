package com.pard.hw2.user.service;

import com.pard.hw2.user.dto.TheaterDto;
import com.pard.hw2.user.dto.UserDto;
import com.pard.hw2.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void save(UserDto userDto) {
        userRepository.save(userDto);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll();
    }

    public List<UserDto> findMoviesByTheater(String theater) {
        return userRepository.findMoviesByTheater(theater);
    }

    public UserDto findMovieByNameAndTheater(String movieName, String theater) {
        return userRepository.findMovieByNameAndTheater(movieName, theater);
    }

    public void updateTheaterByMovieName(String movieName, TheaterDto theaterDto){
        userRepository.updateTheaterByMovieName(movieName, theaterDto);
    }

    public void delete(String movieName) {
        userRepository.delete(movieName);
    }
}
