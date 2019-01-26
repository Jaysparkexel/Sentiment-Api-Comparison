/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.StatusDeletionNotice;
import twitter4j.*;

/**
 *
 * @author Jay
 */
public class TwitterApp1 {
    
  static int tweetCount=0;
  static int posCount=0;
  static int negCount=0;
  static int neutCount=0;
  static String sentiment = "";
  static String indexOfSentiment = "";
  

    /**
     * @param args the command line arguments
     */
    
//    static List<Status> status;
//    public static String message = "I will see about your complain as soon as possible."
//            + "Thank you for alerting me.";
    public static AylienCheck aylienCheck = new AylienCheck();
    
    public static void main(String[] args) throws TwitterException{
        
        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.PrintFilterStream [follow(comma separated numerical user ids)] [track(comma separated filter terms)]");
            System.exit(-1);
        }
        
        
        
        // TODO code application logic here
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey("")
        .setOAuthConsumerSecret("")
        .setOAuthAccessToken("")
        .setOAuthAccessTokenSecret("");
        
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance(); 
        
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                tweetCount++;
                try {
                    sentiment = aylienCheck.checkPositivity(status.getText());
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(TwitterApp1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Sentiment of tweet: "+sentiment);
                if(sentiment.equals("positive")){
                    posCount++;
                    indexOfSentiment = "+1";
                }
                if(sentiment.equals("neutral")){
                    neutCount++;
                    indexOfSentiment = "0";
                }
                if(sentiment.equals("negative")){
                    negCount++;
                    indexOfSentiment = "-1";
                }
                System.out.println("Index of tweet:"+tweetCount);
                System.out.println(""+indexOfSentiment +" : " +"@" + status.getUser().getScreenName() + " - " + status.getText());
                System.out.println("Positive:" +posCount +" | " +"Negative:" +negCount +" | " +"Neutral:" +neutCount);
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };
        
        FilterQuery fq = new FilterQuery();
        ArrayList<String> keywords = new ArrayList<String>();
        for(String arg:args){
            keywords.addAll(Arrays.asList(arg.split(",")));
        }
        
        String[] trackKey = keywords.toArray(new String[keywords.size()]);
        FilterQuery filter = new FilterQuery();
        filter.track(trackKey);
        twitterStream.addListener(listener);
        twitterStream.filter(filter);

    }

    public TwitterApp1() {
        this.tweetCount = 0;
    }
        
          
}
