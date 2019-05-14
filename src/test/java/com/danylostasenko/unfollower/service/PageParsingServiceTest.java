package com.danylostasenko.unfollower.service;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static org.junit.Assert.*;

public class PageParsingServiceTest {

    private static final String PATH_TO_FILE = "C:\\Users\\Danylo\\Documents\\github-unfollower\\github-danylo-stasenko.html";

    private PageParsingService service = new PageParsingService();

    @Test
    public void givenSinglePageWithFollowers_whenParsingFollowers_thenReturnValidFollowersCount() throws Exception{
        // GIVEN
        String code = readFile(PATH_TO_FILE);

        // WHEN
        List<String> followers = service.getFollowers(code);

        // THEN
        assert (followers.size() == 50);
    }

    private String readFile(String path) throws Exception{
        InputStream is = new FileInputStream(path);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));

        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();

        while(line != null){
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
    }
}