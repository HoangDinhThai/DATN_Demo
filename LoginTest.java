package DATN.E_commerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
	private final By avatarFiled = By.className("profile");
	private final By phonenumberID = By.id("txtPhoneNumber");
	private final By messageError = By.xpath("//*[@id=\"frmGetVerifyCode\"]/label");
	private final By submitButton = By.className("btn");
	private final By submitOTPButton = By.xpath("/html/body/section/div/div[2]/form/button");

	@Test(priority = 1)
	public void LoginFailed_EmptyPhone() {
		click(avatarFiled);
		pause(2000);
		input(phonenumberID, "");
		pause(2000);
		click(submitButton);
		pause(2000);
		WebElement errorElement = driver.findElement(messageError);
		String errorText = errorElement.getText();
		System.out.println("[❌ Login Failed - Empty Phone] → Error message displayed: \"" + errorText + "\n");
	}

	@Test(priority = 2)
	public void LoginFailed_InvalidPhone() {
		click(avatarFiled);
		pause(2000);
		input(phonenumberID, "01234567891");
		pause(2000);
		click(submitButton);
		pause(2000);
		WebElement errorElement = driver.findElement(messageError);
		String errorText = errorElement.getText();
		System.out.println("[❌ Login Failed - Invalid Phone: 01234567891] → Error message displayed: \"" + errorText + "\n");
	}

	@Test(priority = 3)
	public void LoginSuccess() {
		click(avatarFiled);
		pause(2000);
		input(phonenumberID, "0327738215");
		pause(2000);
		click(submitButton);
		pause(1000);
		System.out.println("[🔐 OTP Stage Reached - Valid Phone: 0327738215] → Waiting for OTP input..." + "\n");
		pause(30000); 
		click(submitOTPButton);
		System.out.println("[✅ OTP Submitted] → Submitted OTP, please verify login manually.");
		pause(30000);
	}
}