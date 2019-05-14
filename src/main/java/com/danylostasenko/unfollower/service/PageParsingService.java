package com.danylostasenko.unfollower.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PageParsingService {

    private static Logger log = Logger.getLogger(PageParsingService.class.getName());
    private static final String PATTERN = "pl-1\">(.+)<";

    // todo: iterate over all pages to get all users. Currently working with only one page (50 users)
    public List<String> getFollowers(String code){
        log.info("Parsing users...");

        Pattern p = Pattern.compile(PATTERN);
        Matcher m = p.matcher(code);

        List<String> users = new ArrayList<>();
        while (m.find()){
            users.add(m.group(1));
        }

        log.info("Found followers: " + users.size() + " : " + users);
        return users;
    }
}
