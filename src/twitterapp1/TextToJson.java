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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TextToJson {
    
    static String currentLine;
    static int lineNo = 0;
    static int var = 1;
  
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:/Users/Jay/Desktop/Projects/Documentation/Samples/tweetSentimentSample.txt");
        BufferedReader br = new BufferedReader(fr);
        
        File fout1 = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/positive.txt");
	FileOutputStream fos1 = new FileOutputStream(fout1);
        BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos1));
        
        File fout2 = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/negative.txt");
	FileOutputStream fos2 = new FileOutputStream(fout2);
        BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(fos2));
        
        File fout3 = new File("C:/Users/Jay/Desktop/Projects/Documentation/Samples/neutral.txt");
	FileOutputStream fos3 = new FileOutputStream(fout3);
        BufferedWriter bw3 = new BufferedWriter(new OutputStreamWriter(fos3));
        
        while ((currentLine = br.readLine()) != null){
            lineNo++;
            System.out.println(""+lineNo +" - " +currentLine);
           
                    
                
                String[] parts = currentLine.split(":");
                String part2 = parts[1];
                if(part2.equals(" positive")){
                    bw1.write(currentLine);
                    bw1.newLine();
                    bw1.write(br.readLine());
                    lineNo++;
                    bw1.newLine();
                    bw1.write(br.readLine());
                    lineNo++;
                    bw1.newLine();
                    bw1.write(br.readLine());
                    lineNo++;
                    bw1.newLine();
                } else if(part2.equals(" negative")){
                    bw2.write(currentLine);
                    bw2.newLine();
                    bw2.write(br.readLine());
                    lineNo++;
                    bw2.newLine();
                    bw2.write(br.readLine());
                    lineNo++;
                    bw2.newLine();
                    bw2.write(br.readLine());
                    lineNo++;
                    bw2.newLine();
                    
                } else {
                    bw3.write(currentLine);
                    bw3.newLine();
                    bw3.write(br.readLine());
                    lineNo++;
                    bw3.newLine();
                    bw3.write(br.readLine());
                    lineNo++;
                    bw3.newLine();
                    bw3.write(br.readLine());
                    lineNo++;
                    bw3.newLine();
                }
               
            
        }
        
        br.close();
        bw1.close();
        bw2.close();
        bw3.close();
        
        
        
    }
    
}
