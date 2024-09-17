package Selenium.SeleniumPractice;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Interview {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<WebElement> allNames = driver.findElements(By.xpath("//td[1]"));

		for (int i = 0; i < allNames.size(); i++) {
			String text = allNames.get(i).getText();
			
			if(text.contains("Rice")) {
		String price =		driver.findElements(By.xpath("//td[1]/following-sibling::td[1]")).get(i).getText();
		System.out.println(price);
			}
			
		}
		driver.close();
	}

}
