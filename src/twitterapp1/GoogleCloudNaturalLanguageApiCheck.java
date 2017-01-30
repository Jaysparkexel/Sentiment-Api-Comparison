/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

/**
 *
 * 
 * @author Jay
 */

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GoogleCloudNaturalLanguageApiCheck {
    
    static String content = "@RailMinIndia plzz send tc in 6:42am n 6:56 am CST train from shahad in firs class many student n people eithout ticket fearless...";

    public static String checkPositivity(String sentence) throws ParseException{
    try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpPost request = new HttpPost("https://language.googleapis.com/v1/documents:analyzeSentiment?fields=documentSentiment&key=AIzaSyAHGfKm9R4WRD6vIOrrqjVHv56_ggBWjgc");
            StringEntity params = new StringEntity("{\n" +
            " \"document\": {\n" +
            "  \"content\": \""+sentence +"\",\n" +
            "  \"type\": \"PLAIN_TEXT\"\n" +
            " },\n" +
            " \"encodingType\": \"UTF8\"\n" +
            "}");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            //String respond = result.getStatusLine().getReasonPhrase();
            //int statuscode = result.getStatusLine().getStatusCode();
            try {
                JSONParser parser = new JSONParser();
                Object resultObject = parser.parse(json);
                JSONObject jsonObject = (JSONObject) resultObject; 
                JSONObject senti = (JSONObject)jsonObject.get("documentSentiment");
                String sen1 = senti.toString();
                String sen2 = sen1.substring(9);
                String sen3 = (sen2.split(",\"magnitude\""))[0];
                
                float score = Float.parseFloat(sen3);
                
                String sentiment = "";
                
                if(score >= .25){
                    sentiment = "positive";
                }
                else if(score <= -0.35){
                    sentiment = "negative";
                } else {
                    sentiment = "neutral";
                }
                
                return sentiment +" : " + score;

            } catch (Exception e) {
                return "Not Supported";
                //return "" +statuscode +":" +respond;
            }

        } catch (IOException ex) {
            return "Not Supported";
        }
    }
    
    
   
}
    

