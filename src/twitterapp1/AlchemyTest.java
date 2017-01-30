/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.simple.parser.ParseException;
import static twitterapp1.TextToJson.currentLine;

/**
 *
 * @author Jay
 */
public class AlchemyTest {
    static AlchemyApiCheck alchemiApiCheck = new AlchemyApiCheck();
    
    static int posCount=0;
    static int negCount=0;
    static int neutCount=0;
    static int notSuppoCount=0;
    static String sentiment = "";
    static String indexOfSentiment = "";
    static String sentiType;
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
        FileReader fr = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/tweetSentimentSample.txt");
        BufferedReader br = new BufferedReader(fr);
        
        File fout = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/TweetsSampleAlchemy.txt");
	FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
        while ((currentLine = br.readLine()) != null){
            
            String Line1 = currentLine;
            String Line2 = br.readLine();
            String Line3 = br.readLine();
            String Line4 = br.readLine();
            
            if(Line3 != null){
            
                if(Line3.contains(" - ")){
                    String tweet = (Line3.split(" - ", 2))[1];
                    String userSide = (Line3.split(" - ", 2))[0];
                    String user = (userSide.split(" : "))[1];
                    try {
                       sentiType = alchemiApiCheck.checkPositivity(tweet);
                    }
                    catch(com.ibm.watson.developer_cloud.service.exception.BadRequestException e){
                       sentiType = "Not Supported";
                    }

                    if(sentiType.equals("positive")){
                        posCount++;
                        indexOfSentiment = "+1";
                    }
                    if(sentiType.equals("neutral")){
                        neutCount++;
                        indexOfSentiment = "0";
                    }
                    if(sentiType.equals("negative")){
                        negCount++;
                        indexOfSentiment = "-1";
                    }
                    if(sentiType.equals("Not Supported")){
                        indexOfSentiment = "3";
                        notSuppoCount++;

                    }

                    String nLine1 = "Sentiment of tweet: "+sentiType;
                    String nLine2 = Line2;
                    String nLine3 = ""+indexOfSentiment +" : " + user + " - " + tweet;
                    String nLine4 = "Positive:" +posCount +" | " +"Negative:" +negCount +" | " +"Neutral:" +neutCount +" | " +"Not Supported:" +notSuppoCount;

                        bw.write(nLine1);
                        System.out.println(nLine1);
                        bw.newLine();
                        bw.write(nLine2);
                        System.out.println(nLine2);
                        bw.newLine();
                        bw.write(nLine3);
                        System.out.println(nLine3);
                        bw.newLine();
                        bw.write(nLine4);
                        System.out.println(nLine4);
                        bw.newLine();

                }
            }
            
        }
        
       br.close();
       bw.close();
    }
    
}
