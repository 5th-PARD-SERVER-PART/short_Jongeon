package com.pard.hw3.user.repository;

import com.pard.hw3.user.dto.MovieDto;
import com.pard.hw3.user.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Movie findByMovieName(String movieName);

    List<Movie> findMoviesByScreenTimeGreaterThan(int screenTime);

    List<MovieDto>findByTheater(String theater);

    void deleteByTheater(String theater);
}
