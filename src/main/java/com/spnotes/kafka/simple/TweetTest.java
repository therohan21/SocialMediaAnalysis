package com.spnotes.kafka.simple;





import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
	public class TweetTest {

	

	public static void run(String consumerKey, String consumerSecret, String token, String secret) throws InterruptedException {
	    BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10000);
	    StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
	    // add some track terms
	    endpoint.trackTerms(Lists.newArrayList("worldcup", "#icc"));
	    
	    
	    Authentication auth = new OAuth1(consumerKey, consumerSecret, token, secret);
	    // Authentication auth = new BasicAuth(username, password);

	    // Create a new BasicClient. By default gzip is enabled.
	    Client client = new ClientBuilder()
	            .hosts(Constants.STREAM_HOST)
	            .endpoint(endpoint)
	            .authentication(auth)
	            .processor(new StringDelimitedProcessor(queue))
	            .build();

	    // Establish a connection
	    client.connect();

	    // Do whatever needs to be done with messages
	    for (int msgRead = 0; msgRead < 1000; msgRead++) {
	      String msg = queue.take();
	      System.out.println(msg);
	    }

	    client.stop();

	  }
	  public static void main(String[] args) {
	    try {
	      String consumerKey = "tVzxPoxjeUd864cWQ4OuflLgi";
	      String consumerSecret = "jWCW0oU9XenjUfO8FqK56ysuhUs1L5J4Dq6ZAKyF9Qq1TQFxbQ";
	      String token = "131145228-zTr5W6HGd4EbykJvRpkokv3whgnm3X5yQBLEBHwF";
	      String secret = "Om1aIWvdCGJACFnPKbxOZOH89DYAmLmAEWDlJzmnNkA4J";
	      TweetTest.run(consumerKey, consumerSecret, token, secret);
	    } catch (InterruptedException e) {
	      System.out.println(e);
	    }
	  }
}