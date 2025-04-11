package com.pard.hw3.user.service;

import com.pard.hw3.user.dto.MovieDto;
import com.pard.hw3.user.dto.UpdateFieldDto;
import com.pard.hw3.user.entity.Movie;
import com.pard.hw3.user.repository.MovieRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Builder
public class MovieService {
    private final MovieRepository movieRepository;

    public void save(MovieDto movieDto){
        Movie movie = Movie.builder()
                        .movieName(movieDto.getMovieName())
                        .theater(movieDto.getTheater())
                        .screenTime(movieDto.getScreenTime())
                        .date(movieDto.getDate())
                        .build();

        movieRepository.save(movie);
    }

    public List<MovieDto> findLongMovie(int screenTime){
        List<MovieDto> movieDtos = movieRepository.findMoviesByScreenTimeGreaterThan(screenTime).stream()
                .map(movie -> MovieDto.builder()
                        .movieName(movie.getMovieName())
                        .screenTime(movie.getScreenTime())
                        .theater(movie.getTheater())
                        .date(movie.getDate())
                        .build()
                ).toList();
        return movieDtos;
    }

    @Transactional
    public void updateMovieField(String movieName, UpdateFieldDto updateFieldDto){
            Movie movie = movieRepository.findByMovieName(movieName);
        System.out.println(updateFieldDto.getMovieField());
            updateFieldDto.getMovieField().update(movie, updateFieldDto.getValue());

            movieRepository.save(movie);
    }


    public List<MovieDto> findMoviesByTheater(String theater) {
        return movieRepository.findByTheater(theater).stream()
                .map(movie -> MovieDto.builder()
                        .movieName(movie.getMovieName())
                        .screenTime(movie.getScreenTime())
                        .theater(movie.getTheater())
                        .date(movie.getDate())
                        .build())
                .toList();
    }

    public void delete(String movieName){
        Movie movie = movieRepository.findByMovieName(movieName);
        movieRepository.delete(movie);
    }

    @Transactional
    public void deleteMoviesByTheater(String theater) {
        movieRepository.deleteByTheater(theater);
    }
}
