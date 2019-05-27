package com.danylostasenko.unfollower.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import utils.FileWriterUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FollowingParsionService {

    public static void main(String[] args) throws Exception {
        File input = new File("following-3.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://danylo-stasenko.com");

        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 50; i++){
            try {
                Element element = doc.select("#js-pjax-container > div > div.col-9.float-left.pl-2 > div.position-relative > div:nth-child(" + i + ") > div.d-table-cell.col-9.v-align-top.pr-3 > a > span.f4.link-gray-dark").first();
                list.add(element.toString());
                System.out.println(element);
            } catch (Exception e){
                break;
            }
        }

        System.out.println("list size: " + list.size());

        FileWriterUtil.writeToFile(list, "following-3.txt");

    }
}
