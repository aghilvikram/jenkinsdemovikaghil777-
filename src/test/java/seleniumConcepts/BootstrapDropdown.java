package seleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> elements=driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//label"));
		System.out.println(elements.size());
		
		for(WebElement ele:elements) {
			//System.out.println(ele.getText());
			if(ele.getText().contains("Angular")) {
				ele.click();
				break;
			}
		}
		
		
		
		
	}

}
