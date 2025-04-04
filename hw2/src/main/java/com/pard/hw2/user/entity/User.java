package com.pard.hw2.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private String movieName;
    private String theater;
    private int screenTime;

    public void updateTheater(String theater){
        this.theater = theater;
    }

    public void updateScreenTime(int screenTime){
        this.screenTime = screenTime;
    }
}
