package StepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonShopping {
	private WebDriver driver;
	
	@Given("User is on the Amazon login page")
	public void user_is_on_the_amazon_login_page() {
      driver = WebDriverManager.getDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Go to Amazon login page
	    driver.get("https://www.amazon.ca/");
	}

	@When("User clicks on the Sign in button")
	public void user_clicks_on_the_sign_in_button() {
        
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement signinButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		signinButton.click();
	}

	@And("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		usernameField.sendKeys("tejal.a.gunjal@gmail.com");
		
	    driver.findElement(By.id("continue")).click();
		
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		passwordField.sendKeys("Amazon@123");
	}

	@When("User clicks on the Signin Submit button")
	public void user_clicks_on_the_signin_submit_button() {
        
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement signinSubmit = driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]"));
		signinSubmit.click();
	}

	@Then("User should be able to logged in succeffuly and redirected to the home page")
	public void user_should_be_able_to_logged_in_succeffuly_and_redirected_to_the_home_page() {
        
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String expectedTitle = "Hello, Tejal"; 
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList-nav-line-1\"]")).getText();
		
		assertEquals(expectedTitle, actualTitle);
	}

	@Given("User searches for {string}")
	public void user_searches_for(String bookTitle) {
        
		driver = WebDriverManager.getDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
	    searchBar.sendKeys(bookTitle);
	    
	    WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
	    searchButton.click();
	}

	@And("User selectes the book")
	public void user_selectes_the_book() {
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement selectBook = driver.findElement(By.partialLinkText("100+ Solutions in Java"));
		selectBook.click();
	}

	@When("User sets the quanitity to {int}")
	public void user_sets_the_quanitity_to(Integer int1) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement selectQuantity = driver.findElement(By.id("quantity"));
	    selectQuantity.sendKeys("2");
	}

	@And("User adds the book to the cart")
	public void user_adds_the_book_to_the_cart() {
        
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement addToCart = driver.findElement(By.cssSelector("input#add-to-cart-button"));
		addToCart.click();
	}

	@Then("User navigate to the cart and verifies the product, quanitity, and amount")
	public void user_navigate_to_the_cart_and_verifies_the_product_quanitity_and_amount() {
		WebElement selectCart = driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a"));
		selectCart.click();
		
		String expectedProduct = "100+ Solutions in Java: A Hands-On Introduction to Programming in Java (English Edition)";
		String expectedQuantity = "2";
		String expectedAmount = " $25.98";
		
		String actualProduct = driver.findElement(By.cssSelector(".a-truncate-cut")).getText();
		String actualQuantity = driver.findElement(By.cssSelector(".a-dropdown-prompt")).getText();
		String actualAmount = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
		
		assertEquals(expectedProduct, actualProduct);
		assertEquals(expectedQuantity, actualQuantity);
		assertEquals(expectedAmount, actualAmount);
	}



}
