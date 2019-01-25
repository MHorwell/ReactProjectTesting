package react.project;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReactProjectSteps {
	
	WebElement element;
	WebDriverWait wait;
	ExtentTest test;
	WebDriver driver;
	LandingPage landingPage;
	TestingExerciseForm testingExerciseForm;
	Actions action;
		
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constant.DRIVERPATH + Constant.CHROMEDRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		test = ReactTestRunner.report.startTest("Test");
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
		ReactTestRunner.report.endTest(test);
	}
	
	
	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {
		driver.get(Constant.URL);
		landingPage = PageFactory.initElements(driver, LandingPage.class);
		test.log(LogStatus.INFO, "Landing page loaded");
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {
		landingPage.goToExerciseFormPage();
		testingExerciseForm = PageFactory.initElements(driver, TestingExerciseForm.class);
		test.log(LogStatus.INFO, "Automated Testing Exercise Form loaded");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String country) {
		testingExerciseForm.selectCountry(country, wait);
		test.log(LogStatus.INFO, "Country \"" + country + "\" Selected");
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String email) {
	    testingExerciseForm.inputEmail(email);
	    test.log(LogStatus.INFO, "Email \"" + email + "\"  entered");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String password){
	    testingExerciseForm.inputPassword(password);
	    test.log(LogStatus.INFO, "First password \"" + password + "\" entered");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String password) {
		testingExerciseForm.inputPasswordTwo(password);
		test.log(LogStatus.INFO, "Second password \"" + password + "\" entered");
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {
		testingExerciseForm.submitForm();
	    String loginCheck = testingExerciseForm.checkSuccessHeader();
	    if (loginCheck.equals("Success!")) {
	    	test.log(LogStatus.PASS, "Form submitted successfully");
	    } else {
	    	test.log(LogStatus.FAIL, "Form wasn't submitted successfully");
	    }
	    assertEquals("The success header doesn't show \"Success!\"", loginCheck,"Success!");
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String wrongPassword) {
		testingExerciseForm.inputPasswordTwo(wrongPassword);
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {
		testingExerciseForm.submitForm();
		String passwordMatch = testingExerciseForm.passwordMatchCheck();
	    if (passwordMatch.equals("The passwords do not match")) {
	    	test.log(LogStatus.PASS, "Unmatching passwords were found");
	    } else {
	    	test.log(LogStatus.FAIL, "Unmatching passwords were missed");
	    }
	    assertEquals("The page doesn't show \"The passwords do not match\"", passwordMatch, "The passwords do not match");
	}


}
