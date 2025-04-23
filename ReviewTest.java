package DATN.E_commerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ReviewTest extends BaseTest {
	private final By searchBox = By.xpath("//*[@id=\"skw\"]");
	private final By searchButton = By.className("icon-search");
	private final By product = By.xpath("//a[@data-id='322876']");
	private final By reviewButton = By.xpath("//div[@class='c-btn-rate btn-write']");
	private final By ratingStar_5 = By.xpath("//div[@class='popup-rating-topzone']//li[5]");
	private final By contentRating = By.xpath("//textarea[@placeholder='Mời bạn chia sẻ thêm cảm nhận...']");
	private final By nameUserRating = By.xpath("//input[@placeholder='Họ tên (bắt buộc)']");
	private final By phonenumberUserRating = By.xpath("//input[@placeholder='Số điện thoại (bắt buộc)']");
	private final By policyRating = By.xpath("//div[@id='agree-policy-rating']//span");
	private final By submitReview = By.xpath("//div[@class='dcap']");
	private final By closePopupSuccessButton = By.xpath("//div[@class='close-popup-success']");

	private String dataInput() {
		return "Điện thoại này có thiết kế đẹp, hiệu năng ổn định, camera chụp ảnh tốt trong tầm giá. Pin dùng khá lâu, đủ cho một ngày sử dụng. Tuy nhiên, màn hình có thể không quá xuất sắc so với các dòng cao cấp hơn.";
	}

	private String nameInput() {
		return "Hoàng Đình Thái";
	}

	private String phoneInput() {
		return "0327738215";
	}

	public void performSearch(String keyword) {
		input(searchBox, keyword);
		click(searchButton);
		pause(2000);
	}

	private void executeRating() {
		click(product);
		pause(2000);
		
		click(reviewButton);
		pause(3000);

		click(ratingStar_5);
		pause(2000);

		input(contentRating, dataInput());
		pause(2000);

		input(nameUserRating, nameInput());
		pause(2000);

		input(phonenumberUserRating, phoneInput());
		pause(2000);

		click(policyRating);
		pause(2000);

//		click(submitReview);
//		pause(2000);
//
//		click(closePopupSuccessButton);
//		pause(1000);
	}

	@Test(priority = 1)
	public void searchAndRateProduct() {
		performSearch("Masstel Fami 60S 4G");
		executeRating();
	}
}