package Selenium.SeleniumPractice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class DisablePopupBlockingExample {
	static String getPrice(WebElement s) {
	String priceValue =	s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return priceValue;
		
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		//java.util.List<WebElement> a = driver.findElements(By.xpath("//tr/td[1]"));
		 List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));

	        List<String> prices = elements.stream()
	                .filter(element -> element.getText().contains("Wheat"))
	                .map(element -> getPrice(element))
	                .collect(Collectors.toList());
		prices.forEach(price->System.out.println(price));
		
	}
}
