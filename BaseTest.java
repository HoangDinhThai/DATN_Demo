package DATN.E_commerce;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected WebDriver driver;
	protected WebDriverWait mywait;

	@BeforeClass
	public void setup() {
		String urlWeb = "https://www.thegioididong.com/";
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(urlWeb);

		List<WebElement> closeButtons = driver.findElements(By.xpath("/html/body/div[8]/div[1]/div/div"));
		if (!closeButtons.isEmpty()) {
			closeButtons.get(0).click();
		}

		try {
			WebElement closeButton = new WebDriverWait(driver, Duration.ofSeconds(3))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='close']")));
			closeButton.click();
		} catch (Exception e) {
			System.out.println("Không có popup xuất hiện." + "\n");
		}

		pause(1000);
	}

	public void performSearch(String keyword) {
		WebElement searchBox = mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"skw\"]")));
		searchBox.clear();
		searchBox.sendKeys(keyword);
		pause(1500);

		WebElement searchButton = mywait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-search")));
		searchButton.click();
		pause(2500);

		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/aside/div[3]/ul")));
		pause(1500);

		List<WebElement> results = driver.findElements(By.xpath("//ul[contains(@class, 'listproduct')]/li[a]"));
		if (results.isEmpty()) {
			System.out.println("\nKhông tìm thấy kết quả phù hợp cho từ khóa: " + keyword);
		} else {
			System.out.println("\nĐã tìm thấy " + results.size() + " kết quả phù hợp cho từ khóa: " + keyword);
		}
	}

	public void pause(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}

	protected void click(By locator) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	protected void input(By locator, String value) {
		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		element.sendKeys(value);
	}

	protected void waitForVisible(By locator) {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected void verifyAlertMessage(By locator, String expectedText) {
		String actualText = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		System.out.println("Hiển thị cảnh báo bắt buộc: " + actualText);
		Assert.assertEquals(actualText, expectedText);
	}

	protected void orderSuccess(By locator, String expectedText) {
		String actualText = mywait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		System.out.println("\nHiển thị thông báo: " + actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void scrollToElement(By locator) {
	    WebElement element = driver.findElement(locator);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'})", element);
	}
	
	public void clickAddToCart() {
		WebElement buyNowButton = driver.findElement(By.cssSelector("a.btn-buynow"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyNowButton);
	}
	
	protected void cancelProduct() {
		WebElement cancelBtn = driver.findElement(By.xpath("//a[contains(@class, 'text-[#DD1C1A]') and text()='Hủy']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelBtn);
	}

//	@AfterClass
//	public void tearDown() {
//		if (driver != null) {
//			driver.quit();
//		}
//	}
}