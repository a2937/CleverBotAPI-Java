package cleverbotapi;

import java.net.*;
import java.io.*;
import com.google.gson.*;

public class CleverBotQuery
{
    /* Constants */
    public static final String URL_STRING = "http://www.cleverbot.com/getreply?key=";

    /* Instance Variables */
    private String key;
    private String conversationID;
    private String phrase;
    private String response;
    private int random;

    /* Getters & Setters */
    public String getPhrase()
    {
        return this.phrase;
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }

    public String getResponse()
    {
        return this.response;
    }

    private void setResponse(String response)
    {
        this.response = response;
    }

    public String getAPIKey()
    {
        return this.key;
    }

    public void setConversationID(String conversationID)
    {
        this.conversationID = conversationID;
    }

    private void setRandomNumber(String number)
    {
        this.random = Integer.parseInt(number);
    }

    public int getRandomNumber()
    {
        return this.random;
    }

    public String getConversationID()
    {
        return this.conversationID;
    }

    public void sendRequest()throws IOException
    {
        /* Create & Format URL */
        URL url = new URL(CleverBotQuery.formatRequest(CleverBotQuery.URL_STRING, this.getAPIKey(), this.getPhrase(), this.getConversationID()));

        /* Open Connection */
        URLConnection urlConnection = url.openConnection();

        /* Read input */
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine = in.readLine();

        /* Create JSON Object */
        JsonObject jsonObject = new JsonParser().parse(inputLine).getAsJsonObject(); // convert to JSON

        /* Get params */
        this.setConversationID(jsonObject.get("cs").getAsString()); // update conversation ID
        this.setResponse(jsonObject.get("output").getAsString()); // get output
        this.setRandomNumber(jsonObject.get("random_number").getAsString()); // get output
        in.close(); // close!
    }

    public CleverBotQuery(String key, String phrase)
    {
        this.key = key;
        this.setConversationID("");
        this.setPhrase(phrase);
    }

    /* Helper Methods */
    private static String formatRequest(String url, String key, String phrase, String conversationID)
    {
        String formattedPhrase = phrase.replace(' ', '+');
        if (conversationID.equals(""))
        {
            return url + key + "&input=" + formattedPhrase + "&wrapper=Headline22JavaAPI";
        }
        else
        {
            return url + key  + "&input=" + formattedPhrase + "&wrapper=Headline22JavaAPI" + "&cs=" + conversationID;
        }
    }
}
