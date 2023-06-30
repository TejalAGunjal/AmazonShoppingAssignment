package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private static WebDriver driver;
	private WebDriverManager() {
       //Private constructor to prevent instantiation
    }
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
        	// Set Chrome Driver Path
    		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\ASHUTOSH\\eclipse-workspace\\AmazonShopping\\src\\test\\resources\\Drivers\\chromedriver.exe");
    	    
    		// Launch Chrome Browser
    		driver=new ChromeDriver();
        }
        return driver;
	
	}
}

