package com.pard.hw3.user.controller;

import com.pard.hw3.user.dto.MovieDto;
import com.pard.hw3.user.dto.UpdateFieldDto;
import com.pard.hw3.user.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieContorller {
    private final MovieService movieService;

    @PostMapping("")
    public void save(@RequestBody MovieDto movieDto) {
        movieService.save(movieDto);
    }


    @GetMapping("{screenTime}")
    public List<MovieDto> longMovie(@PathVariable int screenTime) {
        return movieService.findLongMovie(screenTime);
    }

    @PatchMapping("/{movieName}")
    public void updateField(@PathVariable String movieName, @RequestBody UpdateFieldDto updateFieldDto) {
        movieService.updateMovieField(movieName, updateFieldDto);
    }

    @GetMapping("{theater}")
    public List<MovieDto> findMoviesByTheater(@PathVariable String theater) {
        return movieService.findMoviesByTheater(theater);
    }

    @DeleteMapping("/{movieName}")
    public void delete(@PathVariable String movieName) {
        movieService.delete(movieName);
    }


    @DeleteMapping("/theater/{theater}")
    public ResponseEntity<String> deleteMoviesByTheater(@PathVariable String theater) {
        movieService.deleteMoviesByTheater(theater);
        return ResponseEntity.ok(theater + " 다 삭제했다");
    }
}
