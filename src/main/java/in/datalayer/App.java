package in.datalayer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App
{
    private static String baseUrl = "https://nosqlapi.datalayer.in/v1";
    private static String apiKey = "5854f52d-f979-4456-801c-47b2793917fc";
    private static String connName = "[B@21e288dc";

    public static void main( String[] args ) throws IOException, InterruptedException {
        //add document using rest apis
        RequestData rd = new RequestData();
        rd.setName("sample data via Programming Language: 1");

        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(rd);
        //addDocument(requestBody);

        //get document using rest apis
        getDocument("66223769a4d90b4f21b7ceea");
    }

    public static void addDocument(String body) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .uri(URI.create(baseUrl + "/ramdb22/sample/insertOne"))
                .header("Content-Type", "application/json")
                .header("x-connection-name", connName)
                .header("x-api-key", apiKey)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    public static void getDocument(String _id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + "/ramdb22/sample/findOne?_id=" + _id + "&idType=ObjectId"))
                .header("Content-Type", "application/json")
                .header("x-connection-name", connName)
                .header("x-api-key", apiKey)
                .build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}