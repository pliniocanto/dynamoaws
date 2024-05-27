package com.example.pmac.dynamoaws.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.pmac.dynamoaws.entity.PlayerHistoryEntity;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/v1/players")
public class PlayerController {

    private DynamoDbTemplate dynamoDbTemplate;

    public PlayerController(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @PostMapping("/{username}/games")
    public ResponseEntity<Void> save( @PathVariable("username") String username, @RequestBody ScoreDto scoreDto){

        var entity = PlayerHistoryEntity.fromScore(username, scoreDto);
        
        dynamoDbTemplate.save(entity);

        return ResponseEntity.ok().build();
    }
    

}
