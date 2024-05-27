package com.example.pmac.dynamoaws.config;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {

    @Bean
    public DynamoDbClient dynamoDbClient() {

        // AwsCredentialsProvider awsCredentialsProviderChain = new AwsCredentialsProvider() {
        //     @Override
        //     public software.amazon.awssdk.auth.credentials.AwsCredentials resolveCredentials() {
        //         return new software.amazon.awssdk.auth.credentials.AwsCredentials() {
        //             @Override
        //             public String accessKeyId() {
        //                 return "fakeMyKeyId";
        //             }

        //             @Override
        //             public String secretAccessKey() {
        //                 return "fakeSecretAccessKey";
        //             }
        //         };
        //     }
        
        // };

        return DynamoDbClient.builder()
        .endpointOverride(URI.create("http://localhost:4566"))
        // .credentialsProvider(awsCredentialsProviderChain)
        .region(Region.SA_EAST_1)
        .build();
    }

}
