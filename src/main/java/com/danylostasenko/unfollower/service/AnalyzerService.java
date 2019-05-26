package com.danylostasenko.unfollower.service;

import com.danylostasenko.unfollower.dto.FollowersDto;
import com.danylostasenko.unfollower.dto.UserDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AnalyzerService {
    private static Logger log = Logger.getLogger(AnalyzerService.class.getName());

    private static final String URL = "https://api.github.com/users/";
    private static final String POSTFIX = "/followers?page=";

    private static int PAGES_COUNT = 1;

    public List<FollowersDto> analyzeFollowers(String username){
        log.info("Analyzing username: " + username);
        RestTemplate restTemplate = new RestTemplate();

        boolean allFollowersAnalyzed = false;


        List<FollowersDto> totalFollowers = new ArrayList<>();

        while (!allFollowersAnalyzed){

            String urlToAnalyze = URL + username + POSTFIX + PAGES_COUNT;

            log.info("URL to analyzeFollowers: " + urlToAnalyze);

            ResponseEntity<List<FollowersDto>> responseEntity = restTemplate.exchange(
                    urlToAnalyze,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<FollowersDto>>(){});
            List<FollowersDto> onCurrentPage = responseEntity.getBody();

            if (onCurrentPage.size() > 0){
                log.info("Found " + onCurrentPage.size() + " followers... Continue parsing...");
                totalFollowers.addAll(onCurrentPage);
                PAGES_COUNT++;
            } else {
                log.info("Analysis complete. Total followers: " + totalFollowers.size());
                allFollowersAnalyzed = true;
            }
        }

        return totalFollowers;
    }

    public UserDto analyzeProfile(String username){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDto> response = restTemplate.getForEntity( URL + username, UserDto.class);
        return response.getBody();
    }
}
