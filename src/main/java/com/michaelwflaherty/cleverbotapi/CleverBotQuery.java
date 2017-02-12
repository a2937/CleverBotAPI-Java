/*  CleverBot API Wrapper - A simple Java API Wrapper for CleverBot!
 *
 *  Copyright (C) 2016 Michael Flaherty // michaelwflaherty.com // michaelwflaherty@me.com
 * 
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) 
 * any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see http://www.gnu.org/licenses/.
 */
 
package com.michaelwflaherty.cleverbotapi;

import java.net.*;
import java.io.*;
import com.google.gson.*;

/**
 * A CleverBot Query
 *
 * A <code>CleverBotQuery</code> object contains all of the necessary tools to
 * query CleverBot API's servers
 *
 * @author Michael W Flaherty
 * @version 1.0.2
 */
public class CleverBotQuery
{
    /* Constants */
	
	/**
	* URL String used for CleverBot connection
	*/
    public static final String URL_STRING = "http://www.cleverbot.com/getreply?key=";

    /* Instance Variables */
    private String key;
    private String conversationID;
    private String phrase;
    private String response;
    private int random;

    /* Getters & Setters */
	
	/**
	* Gets the input phrase
	*
	* @return String object containing the input phrase
	*/
    public String getPhrase()
    {
        return this.phrase;
    }

	/**
	* Sets the input phrase.
	*
	* @param phrase input phrase to be sent to CleverBot
	*/
    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }

	/**
	* Gets the response from a request. Must be used after <code>sendRequest()</code>
	*
	* @return String object containing the CleverBot response
	*/
    public String getResponse()
    {
        return this.response;
    }

	/**
	* Sets the response value. Only used internally
	*
	* @param response CleverBot response
	*/
    private void setResponse(String response)
    {
        this.response = response;
    }

	/**
	* Gets the API key
	*
	* @return String object containing the API key
	*/
    public String getAPIKey()
    {
        return this.key;
    }

	/**
	* Sets the unique conversation identifier
	*
	* @param conversationID unique conversation identifier
	*/
    public void setConversationID(String conversationID)
    {
        this.conversationID = conversationID;
    }

	/**
	* Sets the random number. Only used internally
	*
	* @param number number to set
	*/
    private void setRandomNumber(String number)
    {
        this.random = Integer.parseInt(number);
    }

	/**
	* Gets the random number
	*
	* @return random number as an integer
	*/
    public int getRandomNumber()
    {
        return this.random;
    }

	/**
	* Gets conversation identifier
	*
	* @return String object containing the conversation identifier
	*/
    public String getConversationID()
    {
        return this.conversationID;
    }

	/**
	* Sends request to CleverBot servers. API key and phrase should be set prior to this call
	*
	* @throws IOException exception upon query failure
	*/
    public void sendRequest() throws IOException
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

	/**
	* CleverBotQuery constructor
	*
	* @param key API key (cleverbot.com/api) 
	* @param phrase input phrase
	*/
    public CleverBotQuery(String key, String phrase)
    {
        this.key = key;
        this.setConversationID("");
        this.setPhrase(phrase);
    }

    /* Helper Methods */
	/**
	* URL request formater
	*
	* @param url starting url to connect to 
	* @param key API key (cleverbot.com/api)
	* @param phrase input to be sent to CleverBot servers
	* @param conversationID unique conversation identifer
	* @return String object containing properly formatted URL
	*/
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
