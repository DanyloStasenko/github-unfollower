package utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileWriterUtilTest {

    @Test
    public void test(){
        List<String> data = new ArrayList<>();

        data.add("Test string 1");
        data.add("Test string 2");
        data.add("Test string 3");

        FileWriterUtil.writeToFile(data, "test-output.txt");
    }
}