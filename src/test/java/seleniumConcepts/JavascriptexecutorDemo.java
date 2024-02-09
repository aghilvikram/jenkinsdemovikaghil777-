package seleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptexecutorDemo {
	public static void drawBorder(WebElement ele, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
		
	}
	public static String getPageTile(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}


	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freecrm.com");
		WebElement loginButton=driver.findElement(By.xpath("//a[@href='https://ui.freecrm.com']"));
		//driver.findElement(By.name("username")).sendKeys("naveenk");
		//driver.findElement(By.name("password")).sendKeys("test@123");
		
		//drawBorder(loginButton, driver);
		//clickElement(loginButton, driver);
		//System.out.println(getPageTile(driver));
		//scrollPageDown(driver);
		WebElement crm=driver.findElement(By.xpath("//h3[text()='CRM Services']"));
		//generateAlert(driver, "ther is an issue with login button");
		scrollIntoView(driver, crm);
		
		

}}
