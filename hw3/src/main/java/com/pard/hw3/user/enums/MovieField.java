package com.pard.hw3.user.enums;

import com.pard.hw3.user.entity.Movie;

import static java.lang.Integer.parseInt;

public enum MovieField {
    MOVIENAME{
        @Override
        public void update(Movie movie, String value){
            movie.updateMovieName(value);
        }
    },

    THEATER{
        @Override
        public void update(Movie movie, String value){
            movie.updateTheater(value);
        }
    },

    SCREENTIME{
        @Override
        public void update(Movie movie, String value){
            movie.updateScreeTime(parseInt(value));
        }
    },

    DATE{
        @Override
        public void update(Movie movie, String value){
            movie.updateDate(value);
        }
    };

    public abstract void update(Movie movie, String value);
}
