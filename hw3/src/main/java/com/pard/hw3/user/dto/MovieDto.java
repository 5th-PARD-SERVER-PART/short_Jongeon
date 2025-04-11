package com.pard.hw3.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {
    private String movieName;
    private String theater;
    private String date;
    private int screenTime;
}
