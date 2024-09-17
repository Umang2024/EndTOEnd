package Selenium.SeleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustPractice {

	public static void main(String[] args) {
		String userID = "Rinki@gmail.com";
		String userPassword = "Ricky@123";

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys(userID);
		driver.findElement(By.id("userPassword")).sendKeys(userPassword);
		driver.findElement(By.id("login")).click();

		java.util.List<WebElement> productsName = driver.findElements(By.cssSelector("div.card-body h5"));

		for (int i = 0; i < productsName.size(); i++) {
			String productName = productsName.get(i).getText();
			if (productName.equals("IPHONE 13 PRO")) {

				driver.findElements(By.cssSelector(".w-10")).get(i).click();
				break;

			}

		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));

		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		boolean Match = driver.findElement(By.cssSelector(".cartSection h3")).getText().equals("IPHONE 13 PRO");
		System.out.println(Match);

		if (Match) {

			// driver.findElement(By.xpath("//button[text()='Checkout'])")).click();
			driver.findElement(By.xpath("//button[text()='Checkout']")).click(); // Corrected xpath
		}

		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("button.ta-item")));

		List<WebElement> countries = driver.findElements(By.cssSelector("button.ta-item"));
		for (int i = 0; i < countries.size(); i++) {
			String country = countries.get(i).getText();

			if (country.equals("India")) {
				countries.get(i).click();
			}

		}

		driver.findElement(By.cssSelector("a.btnn")).click();
		String confirmationMessage = driver.findElement(By.cssSelector("h1.hero-primary")).getText();

		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));

		driver.quit();

	}

}
