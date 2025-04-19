package DATN.E_commerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest{
	private final By avatarFiled = By.className("profile");
	private final By phonenumberID = By.id("txtPhoneNumber");
	private final By submitButton = By.className("btn");
	private final By submitOTPButton = By.xpath("/html/body/section/div/div[2]/form/button");
	private final By logoutBtn = By.xpath("//a[contains(text(),'Đăng Xuất')]");
	@Test(priority = 3)
	public void LogoutSuccess() {
		click(avatarFiled);
		pause(2000);
		input(phonenumberID, "0327738215");
		pause(2000);
		click(submitButton);
		pause(1000);
		System.out.println("[🔐 OTP Stage Reached - Valid Phone: 0327738215] → Waiting for OTP input..." + "\n");
		pause(30000); // Giữ đủ thời gian nhập OTP bằng tay
		click(submitOTPButton);
		System.out.println("[✅ OTP Submitted] → Submitted OTP, please verify login manually.");
		click(avatarFiled);
		pause(2000);
		click(logoutBtn);
		pause(1000);
	}
}
