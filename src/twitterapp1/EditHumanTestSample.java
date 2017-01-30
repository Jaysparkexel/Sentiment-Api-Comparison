package twitterapp1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jay
 */
public class EditHumanTestSample {
    
    static int posCount=0;
    static int negCount=0;
    static int neutCount=0;
    static int notSuppoCount=0;
    static String sentiment;
    static String indexOfSentiment;
    static String sentiType;
    static String currentLine;
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
         FileReader fr = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/HumanTestSample.txt");
        BufferedReader br = new BufferedReader(fr);
        
        File fout = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/HumanTestSampleEdited.txt");
	FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
        while ((currentLine = br.readLine()) != null){
            
            String Line1 = currentLine;
            String Line2 = br.readLine();
            String Line3 = br.readLine();
            String Line4 = br.readLine();
            String nLine1 = "";
            if(Line1.contains(": ")){
                String leftSen = (Line1.split(": "))[0];
                String senti = (Line1.split(": "))[1];
                if(senti.equals("3")){
                        nLine1 = "Sentiment of tweet: positive";
                    }
                    if(senti.equals("2")){
                        nLine1 = "Sentiment of tweet: neutral";
                    }
                    if(senti.equals("1")){
                        nLine1 = "Sentiment of tweet: negative";
                    }
                    if(senti.equals("4")){
                        nLine1 = "Sentiment of tweet: Not Supported";
                    }
                        bw.write(nLine1);
                        System.out.println(nLine1);
                        bw.newLine();
                        bw.write(Line2);
                        System.out.println(Line2);
                        bw.newLine();
                        bw.write(Line3);
                        System.out.println(Line3);
                        bw.newLine();
                        bw.write(Line4);
                        System.out.println(Line4);
                        bw.newLine();
            }
            
        }
        br.close();
        bw.close();
    }
}
