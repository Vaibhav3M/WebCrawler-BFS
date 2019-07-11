package Model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
	
	public static void main(String args[]) {
		
		BFSCrawler crawler = new BFSCrawler();

		System.out.println("Enter a valid URL ");


		Scanner scan = new Scanner(System.in);
		String root = scan.nextLine();

		String regexp = "http://(\\w+\\.)*(\\w+)";
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(root);

		if(matcher.find()){
			System.out.println("Crawler output: ");

			crawler.callCrawler(root);

		}
		else
		{
			System.out.println("Invalid input. Exiting.....");
		}

		scan.close();

	}

}
