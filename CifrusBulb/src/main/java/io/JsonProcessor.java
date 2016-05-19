package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bogdan on 24/01/16.
 */
public final class JsonProcessor {

    private static JsonProcessor ourInstance = new JsonProcessor();

    public static JsonProcessor getInstance() {
        return ourInstance;
    }

    private JsonProcessor() {
    }

    public void sendJsonString(String inputUrl, String json) throws IOException {
        URL url = new URL(inputUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        PrintStream printStream = new PrintStream(connection.getOutputStream());
        printStream.print(json);
        printStream.flush();
        printStream.close();
        System.out.println(connection.getResponseMessage());
  //      Serializer.saveToHardDrive("D:\\CamLogs\\", json + " totalin:" + Detector.totalIn + ";totalout:" + Detector.totalOut);
        System.out.println(json);
    }

    public String prepareJsonString(Object object) {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(object);
    }
}
