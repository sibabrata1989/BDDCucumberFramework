package objectRepository;

import org.openqa.selenium.By;

public interface OR_App1 {
	// Login Page objects
	By txtUserName = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//input[@type='submit']");

}
