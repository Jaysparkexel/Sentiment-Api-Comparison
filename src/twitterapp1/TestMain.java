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
public class TestMain {
    public static void main(String[] args) {
        String sent = "0 : @mahendrafeeds - @RailMinIndia can you update the details of previous rack (29678,110900,113866) missing details.loaded on 1-12-16 dispatched on 18-12-2016";
        String tweet = (sent.split(" - ", 2))[1];
        System.out.println(tweet);
        
    }
}
