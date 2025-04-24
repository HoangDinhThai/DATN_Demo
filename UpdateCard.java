package DATN.E_commerce;

import java.util.List;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class UpdateCard extends BaseTest {
	private final By product_1 = By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div/div[3]/div/div/div/div[1]/div[1]/div");
	private final By product_2 = By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div/div[3]/div/div/div/div[2]/div[1]/div");
	private final By product_3 = By.xpath("/html/body/div[7]/div/div[1]/div/div[2]/div/div[3]/div/div/div/div[3]/div[1]/div");
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
	private final By priceTotal = By.xpath("//div[@class='total-price']");
	private final By addToCartBtn = By.cssSelector("a.btn-buynow");

	@Test(priority = 1)
	public void writeInformation() throws InterruptedException {
		click(product_1);
		pause(1500);
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
		pause(700);
		input(location, "Ngõ 1 Thôn Yên Kiện");
		pause(500);
		click(confirmBtn);
		pause(1500);
		System.out.println("Thông tin đã được nhập\n");
	}

	@Test(priority = 2)
	public void addProductToCard() throws InterruptedException {
		driver.navigate().back();
		pause(1200);
		click(product_2);
		pause(1500);
		scrollToElement(addToCartBtn);
		pause(1500);
		clickAddToCart();
		pause(1500);
		driver.navigate().back();
		pause(1200);
		click(product_3);
		pause(1500);
		scrollToElement(addToCartBtn);
		pause(1500);
		clickAddToCart();
		pause(1500);
		driver.navigate().back();
		pause(1200);
		click(cardView);
		pause(2000);

		List<WebElement> productlists = driver.findElements(By.xpath("//div[@class='product-list']/div"));
		int actualProductCount = productlists.size();
		int expectedProductCount = 3;

		if (actualProductCount == expectedProductCount) {
			System.out.println("✅ Số sản phẩm: " + actualProductCount + "\n");
		} else {
			System.out.println("\n❌ Số sản phẩm không đúng");
		}

		int index = 1;
		for (WebElement product : productlists) {
			WebElement nameElement = product.findElement(By.xpath(".//a[@class='product-item__name']"));
			String productName = nameElement.getText();
			System.out.println("Sản phẩm " + index + ": " + productName);
			index++;
		}

		WebElement totalPriceElement = driver.findElement(priceTotal);
		String totalPriceText = totalPriceElement.getText().replaceAll("[^0-9]", "");
		int totalPrice = Integer.parseInt(totalPriceText);
		System.out.println("\nTổng tiền: " + totalPrice + " đ\n");
	}

	@Test(priority = 3)
	public void deleteOneProductFromCard() throws InterruptedException {
		click(deleteItem);
		pause(500);
		WebElement deletedProductElement = driver.findElement(By.xpath("//div[@class='product-list']/div[1]//a[@class='product-item__name']"));
		String deletedProductName = deletedProductElement.getText();
		click(deleteBtn);
		pause(2000);

		List<WebElement> updatedProductList = driver.findElements(By.xpath("//div[@class='product-list']/div"));
		int updatedCount = updatedProductList.size();
		int expectedCount = 2;

		System.out.println("✅ Đã xóa: " + deletedProductName);
		System.out.println("Sản phẩm còn lại: " + updatedCount + "\n");

		if (updatedCount == expectedCount) {
			System.out.println("✅ Số lượng đúng\n");
		} else {
			System.out.println("❌ Số lượng không đúng\n");
		}

		int index = 1;
		for (WebElement product : updatedProductList) {
			WebElement nameElement = product.findElement(By.xpath(".//a[@class='product-item__name']"));
			String productName = nameElement.getText();
			System.out.println("Sản phẩm còn lại " + index + ": " + productName + "\n");
			index++;
		}

		WebElement totalPriceElement = driver.findElement(priceTotal);
		String totalPriceText = totalPriceElement.getText().replaceAll("[^0-9]", "");
		int totalPrice = Integer.parseInt(totalPriceText);
		System.out.println("Tổng tiền sau khi xóa: " + totalPrice + "đ\n");
	}

	public void pause(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}
}
