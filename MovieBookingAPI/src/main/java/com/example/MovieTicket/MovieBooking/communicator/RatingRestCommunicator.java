package com.example.MovieTicket.MovieBooking.communicator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingRestCommunicator {

    String base_url = "http://localhost:8081/rating/";

    RestTemplate restTemplate;

    public RatingRestCommunicator(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public long getRating(String id) {
        ResponseEntity<Long> response = restTemplate.exchange(base_url+id, HttpMethod.GET, null, Long.class);
        return response.getBody();
    }

    public void addRating(Map< String,Long > ratingsMap) {
        HttpEntity<Map<String,Long>> request = new HttpEntity<>(ratingsMap);
        restTemplate.exchange(base_url+"add", HttpMethod.POST, request, Void.class);
    }

    public void updateRating(Map< String, Long > ratingsMap) {
        HttpEntity<Map<String, Long>> request = new HttpEntity<>(ratingsMap);
        restTemplate.exchange(base_url+"update", HttpMethod.PUT, request, Void.class);
    }

    public void deleteRating(String id){
        restTemplate.exchange(base_url+"remove/"+id, HttpMethod.DELETE, null, Void.class);
    }
}
