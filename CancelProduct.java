package DATN.E_commerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CancelProduct extends BaseTest {
	private final By product = By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div");
	private final By addToCartBtn = By.cssSelector("a.btn-buynow");
	private final By city = By.xpath("//a[contains(text(),'Hà Nội')]");
	private final By district = By.xpath("//a[contains(text(),'Quận/Huyện')]");
	private final By districtChild = By.xpath("//a[contains(text(),'Huyện Thanh Trì')]");
	private final By commune = By.xpath("//a[contains(text(),'Phường/Xã')]");
	private final By communeChild = By.xpath("//a[contains(text(),'Xã Ngọc Hồi')]");
	private final By location = By.id("hdLocationAddress");
	private final By confirmBtn = By.className("location-confirm");
	private final By cardView = By.xpath("/html/body/header/div[1]/div/a[2]");
	private final By addInfo = By.xpath("//div[@class='info__cart location']");
	private final By genderInfo = By.xpath("//span[normalize-space()='Anh']");
	private final By nameInfo = By.className("capitalize");
	private final By phoneInfo = By.id("cusPhone");
	private final By confirmSubmitBtn = By.xpath("//button[contains(text(),'Xác Nhận')]");
	private final By paymentMethod = By.xpath("//span[contains(text(),'Thanh toán tiền mặt khi nhận hàng')]");
	private final By orderBtn = By.xpath("//button[contains(text(),'Đặt hàng')]");
	private final By messageSuccess = By.xpath("//div[@class='alertsuccess-new']");
	private final By cancelBtn = By.xpath("//a[contains(@class, 'text-[#DD1C1A]') and text()='Hủy']");
	private final By reason = By.xpath("//span[text()='Vấn đề khác']");
	private final By cancelConfirmBtn = By.xpath("//button[@id='crmbtnsubmitsurveyError']");
																																																																																																								
	@Test(priority = 1)
	public void writeInformation() {
		click(product);
		pause(1000);
		scrollToElement(addToCartBtn);
		pause(1500);
		clickAddToCart();
		pause(2000);
		click(city);
		pause(500);
		click(district);
		pause(500);
		click(districtChild);
		pause(500);
		click(commune);
		pause(500);
		click(communeChild);
		pause(500);
		input(location, "Việt Yên");
		pause(500);
		click(confirmBtn);
		pause(2000);
//		clickAddToCart();
		click(cardView);
		pause(2000);
		System.out.println("Đã nhập đầy đủ thông tin");
	}

	@Test(priority = 2)
	public void inputInformation() {
		click(addInfo);
		pause(1000);
		click(genderInfo);
		pause(1000);
		input(nameInfo, "Hang Hoang Tran");
		pause(1000);
		input(phoneInfo, "0934567657");
		pause(1000);
		click(confirmSubmitBtn);
		pause(1000);
		click(orderBtn);
		pause(1000);
	}

	@Test(priority = 3)
	public void checkOrderSuccess() {
		click(paymentMethod);
		pause(2000);
		click(orderBtn);
		pause(20000);
		orderSuccess(messageSuccess, "ĐẶT HÀNG THÀNH CÔNG");
		cancelProduct();
		pause(20000);
		click(reason);
		pause(1000);
		click(cancelConfirmBtn);
		pause(10000);
		System.out.println("HỦY ĐƠN HÀNG THÀNH CÔNG");
	}
}