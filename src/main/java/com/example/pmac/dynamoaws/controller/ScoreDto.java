package com.example.pmac.dynamoaws.controller;

public record ScoreDto(Double score){
    public ScoreDto {
        if(score == null){
            throw new IllegalArgumentException("Score cannot be null");
        }
    }
}
