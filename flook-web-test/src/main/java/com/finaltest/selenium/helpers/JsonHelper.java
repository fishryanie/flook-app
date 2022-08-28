package com.finaltest.selenium.helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonHelper {
    public static Object[][] readOrderListFromJsonFile(String path) {
        Object[][] dataProvider;

        try (Reader reader = new FileReader(path))
        {
            JsonArray array = JsonParser.parseReader(reader).getAsJsonArray();
            JsonObject firstObject = (JsonObject) array.get(0);

            int width = firstObject.size();
            int height = array.size();

            dataProvider = new Object[height][width];

            for(int i = 0; i < height; i++){
                JsonObject object = (JsonObject) array.get(i);
                String key[] = object.keySet().toArray(new String[0]);
                for(int j = 0; j < width; j++){
                    if(object == null){
                        dataProvider[i][j] = "";
                    } else {
                        String dataFromKey = object.get(key[j]).toString();
                        String optimizeData = dataFromKey.replace("\"", "");
                        dataProvider[i][j] = optimizeData;
                    }
                }
            }
            return dataProvider;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }
}
