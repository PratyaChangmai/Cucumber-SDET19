package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SignUp_Definition {
	WebDriver driver;
	
	@Given("Homepage is in English language")
	public void homepage_is_in_english_language() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elearningm1.upskills.in/");
		String languageText = driver.findElement(By.xpath("//button[@class='btn btn-default dropdown-toggle']")).getText();
		if(!languageText.equals("English")) {
			Select homePageLanguage = new Select(driver.findElement(By.xpath("//*[@class='dropdown-menu']")));
			homePageLanguage.selectByVisibleText("English");
		}
		System.out.println("Homepage is displayed in English.");
	}
	
	@When("User clicks on Signup button")
	public void user_clicks_on_signup_button() throws InterruptedException {
		driver.findElement(By.linkText("Sign up!")).click();
		Thread.sleep(3000);
	}

	
	@When("User enters Firstname {string}")
	public void user_enters_firstname(String firstName) {
		driver.findElement(By.id("registration_firstname")).sendKeys(firstName);
	}
	
	@When("User enters Lastname {string}")
	public void user_enters_lastname(String lastName) {
		driver.findElement(By.id("registration_lastname")).sendKeys(lastName);
	}
	
	@When("User enters Email {string}")
	public void user_enters_email(String email) {
		driver.findElement(By.id("registration_email")).sendKeys(email);
	}
	@When("User enters Username {string}")
	public void user_enters_username(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@When("User enters Password {string}")
	public void user_enters_password(String pwd) {
		driver.findElement(By.name("pass1")).sendKeys(pwd);
	}
	
	@When("User enters Confirm Password {string}")
	public void user_enters_confirm_password(String confirmPwd) {
		driver.findElement(By.name("pass2")).sendKeys(confirmPwd);
	}

	@When("User clicks Register button")
	public void user_clicks_register_button() throws InterruptedException {
		driver.findElement(By.id("registration_submit")).click();
		System.out.println("Register button clicked.");
	    Thread.sleep(3000);
	}
	
	@Then("User should see Confirmation message for {string}{string} and Email as {string}")
	public void user_should_see_confirmation_message_for_and_email_as(String firstname, String lastname, String email) {
		String confirmationMsg = driver.findElement(By.xpath("//*[@id='cm-content']//p")).getText();
	    System.out.println(confirmationMsg);
	    Assert.assertEquals(confirmationMsg, "Dear " + firstname + " " + lastname + ",\n\nYour personal settings have been registered.");
	    driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click();
	    String emailTxt = driver.findElement(By.xpath("//div[@class='text-center']/p")).getText();
	    Assert.assertEquals(email, emailTxt);
	    System.out.println("The email address is as expected");
	}

	@When("User clicks Compose button in Homepage")
	public void user_clicks_compose_button_in_homepage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@title='Homepage']")).click();
	    if(!(driver.findElement(By.xpath("//a[text()='Compose']")).isDisplayed())) {
	    	driver.findElement(By.linkText("Profile")).click();
	    	Thread.sleep(2000);
	    }
		driver.findElement(By.xpath("//a[text()='Compose']")).click();
		Thread.sleep(2000);
	}
	
	@When("User enters Email details for {string}")
	public void user_enters_email_details_for(String firstName) throws InterruptedException {
	    driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("naveen");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//li[text()='naveen naveen (naveen)']")).click();
	    driver.findElement(By.id("compose_message_title")).sendKeys("Hi For Testing");
	    Thread.sleep(10000);
	    driver.switchTo().frame(driver.findElement(By.xpath("//*[@title='Rich Text Editor, content']")));
	    driver.findElement(By.xpath("//*[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_"
	    		+ "borders']")).sendKeys("Hello Mr. Naveen,\n   This is for Testing\n\nFrom,\n" + firstName);
	    driver.switchTo().defaultContent();
	}
	
	@When("User clicks on Send button")
	public void user_clicks_on_send_button() throws InterruptedException {
	    driver.findElement(By.id("compose_message_compose")).click();
	    Thread.sleep(3000);
	}
	
	@Then("User should receive an Acknowledgment")
	public void user_should_receive_an_acknowledgment() {
	    String acknowledgementMsg = driver.findElement(By.xpath("//*[@class='alert alert-success']")).getText();
	    System.out.println(acknowledgementMsg);
	    Assert.assertEquals("The message has been sent to naveen naveen (naveen)", acknowledgementMsg);
	    driver.quit();
	}

}
