package seleniumConcepts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.popuptest.com/goodpopups.html");
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
			
			String parentWindowId=it.next();
			System.out.println("parent windowid:"+driver.getTitle());
			String childwindowId = it.next();
			driver.switchTo().window(childwindowId);
			Thread.sleep(3000);
			System.out.println("child windowid:"+driver.getTitle());
			driver.close();
			driver.switchTo().window(parentWindowId);
			Thread.sleep(3000);
		

	}

}
