/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Jay
 */
public class AlchemyApiCheck {
   static AlchemyLanguage service;
   
   public AlchemyApiCheck(){
       service = new AlchemyLanguage();
        service.setApiKey("0bf5ae56fbff706959e4c13f463042b0efd32134");
   }
    
    public static String checkPositivity(String sentence) throws ParseException{
        
        Map<String,Object> params = new HashMap<String, Object>();
        params.put(AlchemyLanguage.TEXT, sentence);
        DocumentSentiment sentiment = service.getSentiment(params).execute();
        JSONParser parser = new JSONParser();
      
            Object obj = parser.parse(sentiment.toString());
            JSONObject jsonObject = (JSONObject) obj; 
            JSONObject senti = (JSONObject)jsonObject.get("docSentiment");
            String sentiType = (String) senti.get("type");
            return sentiType;
        
    }
    
    
}
