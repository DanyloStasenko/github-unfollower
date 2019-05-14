package com.danylostasenko.unfollower.controller;

import com.danylostasenko.unfollower.dto.RequestDto;
import com.danylostasenko.unfollower.dto.ResponseDto;
import com.danylostasenko.unfollower.service.PageParsingService;
import com.danylostasenko.unfollower.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class TestController {

    private static Logger log = Logger.getLogger(TestController.class.getName());

    private PageParsingService parsingService;

    private WebDriver driver;

    @Autowired
    public TestController(PageParsingService parsingService) {
        this.parsingService = parsingService;
    }

    /**
     * Important:
     *  Close Chrome before launching app. It will re-use Your last session.
     * Explanation:
     *  You will be logged-in at all web-sites as usual. It allows application to avoid storing and entering passwords, cookies etc.
     *  In case if Chrome will be opened - Exception will be thrown
     * @param requestDto URL to parse
     * @return parsed user nicknames and count
     */
    @PostMapping("/test")
    public ResponseEntity<ResponseDto> countFollowers(@RequestBody RequestDto requestDto) {
        log.info("Handled [POST] request...");

        // todo: make separate methods/classes and move all logic from controller
        // init driver
        if (driver == null){
            log.info("Initializing driver...");
            driver = WebDriverUtil.getDriver();
        } else {
            log.info("Driver was already initialized");
        }

        // get data
        log.info("Getting data from URL: " + requestDto.getUrl());
        if (!requestDto.getUrl().contains("https://") &&  !requestDto.getUrl().contains("http://")){
            log.info("Adding http prefix...");
            driver.get("http://" + requestDto.getUrl());
        } else {
            log.info("http prefix was already added");
            driver.get(requestDto.getUrl());
        }

        // parse data
        log.info("Parsing data...");
        List<String> followers = parsingService.getFollowers(driver.getPageSource());

        // form response
        log.info("Forming response...");
        ResponseDto response = new ResponseDto();
        response.setUsersSize(followers.size());
        response.setUsers(followers);

        return ResponseEntity.ok(response);
    }
}
