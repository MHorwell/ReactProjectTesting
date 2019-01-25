package react.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestingExerciseForm {
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countrySelector;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement unitedKingdomSelect;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement franceSelect;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement germanySelect;
	
	@FindBy(id = "nameInput")
	private WebElement emailInput;
	
	@FindBy(id = "passInput")
	private WebElement passwordInput;
	
	@FindBy(id = "passInput2")
	private WebElement passwordInputTwo;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/p[10]")
	private WebElement unmatchingPasswordNotifier;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/h1")
	private WebElement successHeader;
	
	public void selectCountry(String country, WebDriverWait wait) {
		
		countrySelector.click();
		wait.until(ExpectedConditions.elementToBeClickable(germanySelect));
		switch (country) {
		case "United Kingdom":
			unitedKingdomSelect.click();
			break;
		case "France": 
			franceSelect.click();
			break;
		case "Germany": 
			germanySelect.click();
			break;
		default: 
			break;
		}
	}
	
	public void inputEmail(String email) {
		emailInput.sendKeys(email);
	}
	
	public void inputPassword(String password) {
		passwordInput.sendKeys(password);
	}
	
	public void inputPasswordTwo(String password) {
		passwordInputTwo.sendKeys(password);
	}
	
	public void submitForm() {
		submitButton.click();
	}
	
	public String passwordMatchCheck() {
		return unmatchingPasswordNotifier.getText();
	}
	
	public String checkSuccessHeader(){
		return successHeader.getText();
	}

}
