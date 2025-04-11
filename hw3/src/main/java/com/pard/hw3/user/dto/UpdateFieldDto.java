package com.pard.hw3.user.dto;


import com.pard.hw3.user.enums.MovieField;
import com.pard.hw3.user.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateFieldDto {
    private MovieField movieField;
    private String value;
}
