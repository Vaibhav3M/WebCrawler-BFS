import Model.BFSCrawler;

public class App {
	
	public static void main(String args[]) {
		
		BFSCrawler crawler = new BFSCrawler();
		
		String root = "https://www.google.com";
		crawler.callCrawler(root);
	}

}
