package com.spnotes.kafka.simple;

import twitter4j.TwitterException;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetStreamer {
	
	public void TweetStreamer() {
		
	}
	
	public void TweetStreamerRunner() throws TwitterException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("tVzxPoxjeUd864cWQ4OuflLgi")
				.setOAuthConsumerSecret("jWCW0oU9XenjUfO8FqK56ysuhUs1L5J4Dq6ZAKyF9Qq1TQFxbQ")
				.setOAuthAccessToken("131145228-zTr5W6HGd4EbykJvRpkokv3whgnm3X5yQBLEBHwF")
				.setOAuthAccessTokenSecret("Om1aIWvdCGJACFnPKbxOZOH89DYAmLmAEWDlJzmnNkA4J");
		
		TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
		
		twitterStream.addListener(new StatusListener () {
			int i = 0;
			
		      public void onStatus(Status status) {
		    	  String st = status.getText();
		    	  System.out.println(st); // print tweets text to console
		    	  System.out.println(i++);
		    	  
		      }
		      
		    
		    
			public void onException(Exception arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}

			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

			public void onTrackLimitationNotice(int arg0) {
				// TODO Auto-generated method stub
				
			}
		
		}  );  
		
		
		FilterQuery tweetFilterQuery = new FilterQuery();
		tweetFilterQuery.track(new String[]{"world cup", "icc"}); 
		tweetFilterQuery.language(new String[]{"en"}); 
		twitterStream.filter(tweetFilterQuery);
		      
	}
	
	public static void main(String args[]) throws TwitterException {
		TweetStreamer ts = new TweetStreamer();
	}
}
