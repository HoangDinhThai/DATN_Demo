package DATN.E_commerce;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UpdateCard extends BaseTest {
	private final By product_1 = By.xpath("/html/body/div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div");
	private final By product_2 = By.xpath("/html/body/div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div");
	private final By product_3 = By.xpath("/html/body/div[7]/div[2]/div[1]/div/div[2]/div/div[3]/div/div/div/div[3]/div[1]/div");
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
	private final By deleteItem = By.xpath("//button[contains(@class, 'product-quantity__btn-minus')]");
	private final By deleteBtn = By.xpath("//button[normalize-space()='Xóa']");

	@Test(priority = 1)
	public void writeInformation() {
		click(product_1);
		pause(1000);
		click(addBtn);
		pause(1000);
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
		System.out.println("Đã nhập đầy đủ thông tin\n");
	}

	@Test(priority = 2)
	public void addProductToCard() {
		click(boxBtn);
		pause(1000);
		driver.navigate().back();
		
		click(product_2);
		pause(1000);
		click(boxBtn);
		pause(1000);
		driver.navigate().back();
		pause(1000);

		click(product_3);
		pause(1000);
		click(boxBtn);
		pause(1000);
		driver.navigate().back();
		pause(1000);

		click(cardView);
		pause(3000);

		List<WebElement> productlists = driver.findElements(By.xpath("//div[@class='product-list']/div"));
		int actualProductCount = productlists.size();
		int expectedProductCount = 3;

		System.out.println("Số sản phẩm mong đợi: " + expectedProductCount);
		System.out.println("\nSố sản phẩm thực tế trong giỏ hàng: " + actualProductCount + "\n");

		if (actualProductCount == expectedProductCount) {
			System.out.println("✅ Kiểm tra thành công: Số lượng sản phẩm đúng\n");
		} else {
			System.out.println("\n❌ Kiểm tra thất bại: Số lượng sản phẩm không đúng");
		}
		for (WebElement product : productlists) {
			WebElement nameElement = product.findElement(By.xpath(".//a[@class='product-item__name']"));
			String productName = nameElement.getText();
			System.out.println("Tên sản phẩm: " + productName + "\n");
		}
	}
	@Test(priority = 3)
	public void deleteOneProductFromCard() {
	    click(deleteItem);
	    pause(1000);
	    WebElement deletedProductElement = driver.findElement(By.xpath("//div[@class='product-list']/div[1]//a[@class='product-item__name']"));
	    String deletedProductName = deletedProductElement.getText();
	    click(deleteBtn);
	    pause(3000);

	    List<WebElement> updatedProductList = driver.findElements(By.xpath("//div[@class='product-list']/div"));
	    int updatedCount = updatedProductList.size();
	    int expectedCount = 2;

	    System.out.println("✅ Đã xóa sản phẩm: " + deletedProductName + "\n");
	    System.out.println("Số sản phẩm mong đợi sau khi xóa: " + expectedCount);
	    System.out.println("Số sản phẩm thực tế còn lại: " + updatedCount + "\n");

	    if (updatedCount == expectedCount) {
	        System.out.println("✅ Kiểm tra thành công: Số lượng sản phẩm sau khi xóa đúng\n");
	    } else {
	        System.out.println("❌ Kiểm tra thất bại: Số lượng sản phẩm sau khi xóa không đúng\n");
	    }
	}

}
