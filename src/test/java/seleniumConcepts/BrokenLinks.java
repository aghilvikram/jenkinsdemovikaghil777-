package seleniumConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	
	
	
	public static void brokenlinks(Object e) throws Exception {
		URL url=new URL((String) e);
		HttpURLConnection openConnection = (HttpURLConnection)url.openConnection();
		openConnection.setConnectTimeout(3000);
		openConnection.connect();
		if(openConnection.getResponseCode()>=400) {
			System.out.println(e+"is a broken link"+openConnection.getResponseMessage()); 
		}
		/*else {
			System.out.println(e+openConnection.getResponseMessage());
		}*/
		}
	

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.caratlane.com");
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		List urllist=new ArrayList();
		for(WebElement e: elements) {
			String links = e.getAttribute("href");
			//URL url=new URL(link);
			
			urllist.add(links);
		}
		
		
	/*	//for(int i=0; i<urllist.size(); i++) {
		long startTime = System.currentTimeMillis();
		urllist.parallelStream().forEach(e -> {
			try {
				brokenlinks(e);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		long endTime = System.currentTimeMillis();
		long totalTime=endTime-startTime;
		System.out.println(totalTime);*/
;		
	}
		
}	
	


