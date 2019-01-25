package react.project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement testingExerciseLink; 
	
	public void goToExerciseFormPage() {
		testingExerciseLink.click();
	}
	

}
