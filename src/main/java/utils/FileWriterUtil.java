package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    public static void writeToFile(Object data, String filename){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            String dataInJson = gson.toJson(data);
            JsonElement je = jp.parse(dataInJson);
            String prettyJsonString = gson.toJson(je);

            FileWriter writer = new FileWriter(filename);
            writer.write(prettyJsonString);
            writer.close();
        } catch (IOException e){
            System.out.println("Exception while writing to file");
        }
    }
}
