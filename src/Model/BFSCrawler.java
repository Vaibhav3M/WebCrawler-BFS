package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BFSCrawler {
	
	private Queue<String> queue;
	private List<String> discoverWebsiteList;
	
	public BFSCrawler() {
		
		this.queue = new LinkedList<String>();
		this.discoverWebsiteList = new ArrayList<>();
		
	}
	
	public String callCrawler(String root) {

		this.queue.add(root);
		
		this.discoverWebsiteList.add(root);
		
		while(!queue.isEmpty()) {
			
			String v = this.queue.remove();
							
			String rawhtml = readURL(v);
			
			String regexp = "http://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawhtml);
			
			while(matcher.find()) {
				
				String actualURL = matcher.group();
				
				if(!discoverWebsiteList.contains(actualURL)) {
					discoverWebsiteList.add(actualURL);
					System.out.println(actualURL);
					queue.add(actualURL);
					
				}	
			}
			
		}
		
		
		return "";
	}
	
	private String readURL(String v) {
		
		String rawhtml = "";
		
		try {
			
			URL url = new URL(v);
			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";
			
			while((inputLine = bReader.readLine()) != null) {
				rawhtml += inputLine; 
				
			}
			
			bReader.close();
			
		}catch(Exception c) {
			c.printStackTrace();
		}
	
		return rawhtml;
		
	}
	
	
}
