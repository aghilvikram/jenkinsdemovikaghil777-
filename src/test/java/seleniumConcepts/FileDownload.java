package seleniumConcepts;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

	public static void main(String[] args) {
		//File folder=new File(UUID.randomUUID().toString());
		//folder.mkdir();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("profile.default_content_settings.popups", 0);
		String filePath=System.getProperty("user.dir");
		map.put("download.default_directory", filePath);
		
		options.setExperimentalOption("prefs", map);
		//DesiredCapabilities cap=DesiredCapabilities.chrome();
		//cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/download");
	    driver.findElement(By.cssSelector(".example a")).click();

	}

}
