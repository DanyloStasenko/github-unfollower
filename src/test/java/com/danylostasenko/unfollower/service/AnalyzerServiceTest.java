package com.danylostasenko.unfollower.service;

import com.danylostasenko.unfollower.dto.FollowersDto;
import org.junit.Test;

import java.util.List;

public class AnalyzerServiceTest {

    private AnalyzerService analyzerService = new AnalyzerService();

    @Test
    public void test(){
        List<FollowersDto> result = analyzerService.analyzeFollowers("danylostasenko");

        System.out.println(result);
    }

}