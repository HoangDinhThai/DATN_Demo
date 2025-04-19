package DATN.E_commerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class OrderProductTest extends BaseTest {
	private final By product = By
			.xpath("/html/body/div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div");
	private final By addBtn = By.xpath("/html/body/section/div[2]/div[2]/div[4]/div[2]/div[6]");
	private final By boxBtn = By.xpath("//a[@class='btn-buynow white']");
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
	private final By genderAlert = By.xpath("//span[contains(text(),'Vui lòng chọn danh xưng')]");
	private final By nameAlert = By.xpath("//span[contains(text(),'Vui lòng nhập họ và tên')]");
	private final By phoneAlert = By.xpath("//span[contains(text(),'Vui lòng nhập số điện thoại')]");
	private final By paymentAlert = By.xpath("//span[@class='is-invalid block pt-2 px-0']");
	private final By nameInvalid = By.xpath("//span[contains(text(),'Họ và tên không hợp lệ')]");
	private final By phoneInvalid = By.xpath("//span[contains(text(),'Số điện thoại không hợp lệ')]");
	private final By paymentMethod = By.xpath("//span[contains(text(),'Thanh toán tiền mặt khi nhận hàng')]");
	private final By orderBtn = By.xpath("//button[contains(text(),'Đặt hàng')]");
	private final By messageSuccess = By.xpath("//div[@class='alertsuccess-new']");

	private void selectLocation() {
		click(city);
		pause(1000);
		click(district);
		pause(1000);
		click(districtChild);
		pause(1000);
		click(commune);
		pause(1000);
		click(communeChild);
		pause(1000);
		input(location, "Ngõ 1 Thôn Yên Kiện");
		pause(1000);
		click(confirmBtn);
		pause(1000);
	}

	private void fillShippingInfo(String name, String phone) {
		click(genderInfo);
		pause(1000);
		input(nameInfo, name);
		pause(1000);
		input(phoneInfo, phone);
		pause(1000);
		click(confirmSubmitBtn);
		pause(1000);
	}

	private void validateRequiredFields() {
		click(addInfo);
		pause(2000);
		click(confirmSubmitBtn);
		pause(2000);
		verifyAlertMessage(genderAlert, "Vui lòng chọn danh xưng");
		verifyAlertMessage(nameAlert, "Vui lòng nhập họ và tên");
		verifyAlertMessage(phoneAlert, "Vui lòng nhập số điện thoại");
	}

	private void verifyInvalidName() {
		click(genderInfo);
		input(nameInfo, "0274327423");
		click(confirmSubmitBtn);
		pause(2000);
		verifyAlertMessage(nameInvalid, "Họ và tên không hợp lệ");
	}

	private void verifyInvalidPhone() {
		click(genderInfo);
		input(phoneInfo, "abcdasdf");
		click(confirmSubmitBtn);
		pause(2000);
		verifyAlertMessage(phoneInvalid, "Số điện thoại không hợp lệ");
	}

	@Test(priority = 1)
	public void writeInformation() {
		click(product);
		pause(1000);
		click(addBtn);
		pause(1000);
		selectLocation();
		System.out.println("Đã nhập đầy đủ thông tin");
	}

	@Test(priority = 2)
	public void addProductToCart() {
		click(boxBtn);
		pause(2000);
		click(cardView);
		pause(3000);
	}

	@Test(priority = 3)
	public void checkEmptyValidationMessages() {
		validateRequiredFields();
	}

	@Test(priority = 4)
	public void checkInvalidName() {
		verifyInvalidName();
	}

	@Test(priority = 5)
	public void checkInvalidPhone() {
		verifyInvalidPhone();
	}

	@Test(priority = 6)
	public void inputValidInformationWithoutPayment() {
		fillShippingInfo("Nguyen Van Thuyen", "0345768434");
		click(orderBtn);
		pause(2000);
		verifyAlertMessage(paymentAlert, "Vui lòng chọn hình thức thanh toán");
	}

	@Test(priority = 7)
	public void checkOrderSuccess() {
		click(paymentMethod);
		pause(2000);
		click(orderBtn);
		pause(2000);
		orderSuccess(messageSuccess, "ĐẶT HÀNG THÀNH CÔNG");
	}
}