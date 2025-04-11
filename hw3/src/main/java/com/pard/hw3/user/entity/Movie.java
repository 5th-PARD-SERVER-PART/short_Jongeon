package com.pard.hw3.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @Column
    private String movieName;

    @Column
    private String theater;

    @Column
    private int screenTime;

    @Column
    private String date;

    @CreationTimestamp
    private Timestamp movieSignUpTime;

    public void updateMovieName(String movieName){
        this.movieName = movieName;
    }

    public void updateTheater(String theater){
        this.theater = theater;
    }

    public void updateScreeTime(int screenTime){
        this.screenTime = screenTime;
    }

    public void updateDate(String date){
        this.date = date;
    }
}
