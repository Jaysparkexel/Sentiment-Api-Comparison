/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

/**
 *
 * @author Jay
 */

import com.aylien.textapi.TextAPIClient;
import com.aylien.textapi.parameters.*;
import com.aylien.textapi.responses.*;
import java.net.URL;


public class AylienCheck {
    
    public String checkPositivity(String st) throws Exception{
        TextAPIClient client = new TextAPIClient("5ba44115", "acb79485e9e49cd41fb39bf234a4f19b");
        SentimentParams sentimentParams = new SentimentParams(st,null,null);
        Sentiment sentiment = client.sentiment(sentimentParams);
        return sentiment.getPolarity();
        
    }
    
//    public static void main(String[] args)  throws Exception {
//        TextAPIClient client = new TextAPIClient("5ba44115", "acb79485e9e49cd41fb39bf234a4f19b");
//        String text = "John is a very good football player!";
//        SentimentParams sentimentParams = new SentimentParams(text,null,null);
//        Sentiment sentiment = client.sentiment(sentimentParams);
//        System.out.printf("nText : %s",sentiment.getText());
//        System.out.printf("nSentiment Polarity   : %s",sentiment.getPolarity());
//        System.out.printf("nPolarity Confidence  : %f",sentiment.getPolarityConfidence());
//        System.out.printf("nSubjectivity : %s",sentiment.getSubjectivity());
//        System.out.printf("nSubjectivity Confidence: %f",sentiment.getSubjectivityConfidence());
//    }
    
    
}
