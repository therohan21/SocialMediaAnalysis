package com.spnotes.kafka.simple;

import java.util.List;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class TweetReader {

	public static void main(String[] args) throws TwitterException{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("tVzxPoxjeUd864cWQ4OuflLgi")
				.setOAuthConsumerSecret("jWCW0oU9XenjUfO8FqK56ysuhUs1L5J4Dq6ZAKyF9Qq1TQFxbQ")
				.setOAuthAccessToken("131145228-zTr5W6HGd4EbykJvRpkokv3whgnm3X5yQBLEBHwF")
				.setOAuthAccessTokenSecret("Om1aIWvdCGJACFnPKbxOZOH89DYAmLmAEWDlJzmnNkA4J");
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter4j.Twitter twitter = tf.getInstance();
		
		List<Status> status = twitter.getHomeTimeline();
		int i = 0;
		for(Status st: status) {
			System.out.println(st.getUser().getName()+"-------"+st.getText());
			System.out.println(i++);
			//System.out.println(st.getUser().getName());
		}
	}
}
