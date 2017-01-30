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

/**
 *
 * @author Jay
 */
public class Compare3API {
    
    static String currentLine1;
    static String currentLine2;
    static String currentLine3;
    
    static int numOfConflict = 0;
    
    public static void main(String[] args) throws FileNotFoundException, IOException  {
        FileReader fr1 = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/tweetSentimentSample.txt");
        BufferedReader br1 = new BufferedReader(fr1);
        FileReader fr2 = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/TweetsSampleAlchemy.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        FileReader fr3 = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/TweetsSampleGoogleCloudNLP35final.txt");
        BufferedReader br3 = new BufferedReader(fr3);
        File fout = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/compareAll3Conflicts.txt");
	FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        
        while(((currentLine1 = br1.readLine()) != null) && ((currentLine2 = br2.readLine()) != null)
                && ((currentLine3 = br3.readLine()) != null)){
            
            String fLine1 = currentLine1;
            String fLine2 = br1.readLine();
            String fLine3 = br1.readLine();
            String fLine4 = br1.readLine();
            
            String sLine1 = currentLine2;
            String sLine2 = br2.readLine();
            String sLine3 = br2.readLine();
            String sLine4 = br2.readLine();
            
            String tLine1 = currentLine3;
            String tLine2 = br3.readLine();
            String tLine3 = br3.readLine();
            String tLine4 = br3.readLine();
 
            if(fLine1.contains(": ") && sLine1.contains(": ") && tLine1.contains(": ") ){
                String tweetSenti1 = (fLine1.split(": "))[1];
                String tweetSenti2 = (sLine1.split(": "))[1];
                String tweetSenti3 = (tLine1.split(": "))[1];
                
                if(!tweetSenti2.equals("Not Supported")){
                    
                    if(!tweetSenti3.equals("Not Supported")){
                
                        if ((!tweetSenti1.equals(tweetSenti2)) || (!tweetSenti2.equals(tweetSenti3)) 
                            || (!tweetSenti1.equals(tweetSenti3)) ){
                            numOfConflict++;
                            bw.write("************************************************************************************************");
                            bw.newLine();
                            bw.write(fLine2);
                            System.out.println(fLine2);
                            bw.newLine();
                            bw.write("----------Aylien----------");
                            bw.newLine();
                            bw.write(fLine1);
                            System.out.println(fLine1);
                            bw.newLine();
                            bw.write(fLine3);
                            System.out.println(fLine3);
                            bw.newLine();

                            bw.newLine();
                            bw.write("----------Alchemy----------");
                            bw.newLine();
                            bw.write(sLine1);
                            System.out.println(sLine1);
                            bw.newLine();
                            bw.write(sLine3);
                            System.out.println(sLine3);
                            bw.newLine();

                            bw.newLine();
                            bw.write("----------Google Cloud----------");
                            bw.newLine();
                            bw.write(tLine1);
                            System.out.println(tLine1);
                            bw.newLine();
                            bw.write(tLine3);
                            System.out.println(tLine3);
                            bw.newLine();

                            bw.newLine();
                            bw.write("Total Number of Conflicting Tweet: "+numOfConflict);
                            bw.newLine();
                            bw.newLine();
                            bw.write("************************************************************************************************");
                            bw.newLine();
                        }
                    }
                }
            }    
        }
        
        br1.close();
        br2.close();
        bw.close();
    }
    
}
