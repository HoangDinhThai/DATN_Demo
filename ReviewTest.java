package DATN.E_commerce;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ReviewTest extends BaseTest {
	private final By product = By
			.xpath("/html/body/div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div");
	private final By reviewButton = By.xpath("//div[@class='c-btn-rate btn-write']");
//    private final By popupNotification = By.xpath("//div[@class='popup-rating-topzone']");
//    private final By ratingStar_1 = By.xpath("//div[@class='popup-rating-topzone']//li[1]");
//    private final By ratingStar_2 = By.xpath("//div[@class='popup-rating-topzone']//li[2]");
//    private final By ratingStar_3 = By.xpath("//div[@class='popup-rating-topzone']//li[3]");
//    private final By ratingStar_4 = By.xpath("//div[@class='popup-rating-topzone']//li[4]");
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

	private void executeRating(By ratingStar) {
		click(product);
		pause(3000);
		
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

		click(submitReview);
		pause(2000);

		click(closePopupSuccessButton);
		pause(1000);
	}

//    @Test(priority = 1)
//    public void RattingSuccess_1() {
//    	executeRating(ratingStar_1);
//    }
//    
//    @Test(priority = 2)
//    public void RattingSuccess_2() {
//    	executeRating(ratingStar_2);
//    }
//    
//    
//    @Test(priority = 3)
//    public void RattingSuccess_3() {
//        executeRating(ratingStar_3);
//    }
//    
//    
//    @Test(priority = 4)
//    public void RattingSuccess_4() {
//       executeRating(ratingStar_4);
//    }

	@Test(priority = 5)
	public void RattingSuccess_5() {
		executeRating(ratingStar_5);
	}
}