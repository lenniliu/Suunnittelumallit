package Facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {

    // Method to fetch the value of the specified attribute from JSON response
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
        String jsonResponse = makeHttpRequest(urlString);
        return extractAttributeFromJson(jsonResponse, attributeName);
    }

    // Step 1: Makes HTTP GET request and returns JSON response as a string
    private String makeHttpRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Handling response from the API
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } catch (IOException e) {
            throw new IOException("Error while making HTTP request: " + e.getMessage(), e);
        } finally {
            con.disconnect();
        }
    }

    // Step 2: Extract the value of a given attribute from the JSON string
    private String extractAttributeFromJson(String jsonResponse, String attributeName) throws IllegalArgumentException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);

            // Check if the attribute exists in the JSON response
            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in the response.");
            }

            return (String) jsonObject.get(attributeName);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error extracting attribute from JSON response: " + e.getMessage(), e);
        }
    }

    // Main method for testing the facade with Chuck Norris joke and another API
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();

        // Demonstrating the facade with the Chuck Norris joke API
        try {
            String joke = facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
            System.out.println("Chuck Norris Joke: " + joke);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        // Demonstrating the facade with another API (Foreign exchange rates)
        try {
            String exchangeRate = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest?base=USD", "EUR");
            System.out.println("Exchange Rate (USD to EUR): " + exchangeRate);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

