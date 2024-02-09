package seleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.asx.com.au/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		driver.findElement(By.xpath("//h5[text()='S&P ASX200 top 5']")).click();
		
		List<WebElement> rowele=driver.findElements(By.xpath("//table[@class='md-bootstrap-tooltip']/caption[text()='Gains']/following-sibling::tr"));
		int noOfRows = rowele.size();
		System.out.println(noOfRows);
		
		//List<WebElement> colele=driver.findElements(By.xpath("//table[@class='md-bootstrap-tooltip']/caption[text()='Gains']/following-sibling::tr/th"));
		List<WebElement> colele=driver.findElements(By.xpath("//*[@id='home_top_five']/div/div[1]/div/div[1]/table/tr[3]/td"));
		
		int noOfCol = colele.size();
		System.out.println(noOfCol);
		
		for(int i=2; i<=noOfRows; i++) {
			for(int j=1; j<=noOfCol; j++) {
				String str=driver.findElement(By.xpath("//table[@class='md-bootstrap-tooltip']/tr["+i+"]/td["+j+"]")).getText();
				if(str.equals("BOSS ENERGY LTD")) {
					System.out.println(driver.findElement(By.xpath("//table[@class='md-bootstrap-tooltip']/tr["+i+"]/td["+j+1+"]")).getText());
				}
			}
			System.out.println();
			
		}
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		/*WebElement data=driver.findElement(By.xpath("//table[@class='md-bootstrap-tooltip']/tr[2]/td[2]"));
		String value = data.getText();
		System.out.println(value);
		driver.quit();

	}*/

	}}
