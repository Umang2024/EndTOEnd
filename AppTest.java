package Selenium.SeleniumPractice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppTest extends BaseTest {

	public static void main(String[] args) throws IOException {
		BaseTest base = new BaseTest();
		base.goToURL();
		driver.findElement(By.id("userEmail")).sendKeys("anshikaji@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Anshika@123");
		driver.findElement(By.id("login")).click();

		// Select product

		List<WebElement> product = driver.findElements(By.cssSelector(".mb-3 b"));

		for (int i = 0; i < product.size(); i++) {

			String name = product.get(i).getText();
			if (name.equals("ADIDAS ORIGINAL")) {
				driver.findElements(By.cssSelector(".btn.w-10.rounded")).get(i).click();
			}
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		List<WebElement> productName = driver.findElements(By.cssSelector("div.cartSection h3"));

		for (int i = 0; i < productName.size(); i++) {
			String nameProduct = productName.get(i).getText();

			if (nameProduct.equals("ADIDAS ORIGINAL")) {
				driver.findElement(By.cssSelector("li.totalRow:nth-child(3) button.btn ")).click();
			}
		}
		driver.findElement(By.cssSelector("input.input.txt.text-validated:nth-child(1)")).sendKeys("Ind");
		List<WebElement> countries = driver.findElements(By.cssSelector("span.ng-star-inserted"));
		for (WebElement country : countries) {
			String countryName = country.getText();
			System.out.println(countryName);
			if (countryName.equals("India")) {
				country.click();
				break;
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a.btnn")));
		driver.findElement(By.cssSelector("a.btnn")).click();
		String confirmationMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase(" Thankyou for the order. "));
	}

}
