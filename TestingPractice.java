package Selenium.SeleniumPractice;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("unused")
public class TestingPractice {
	public static void main(String[] args) throws MalformedURLException, IOException  {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String url = driver.findElement(By.xpath("//a[contains(text(),'REST API')]")).getAttribute("href");
		HttpURLConnection conn

				= (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		
		int b = conn.getResponseCode();
		System.out.println(b);
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File sourc =     ts.getScreenshotAs(OutputType.FILE);
		 File destination = new File("C:\\\\Users\\\\umang\\\\OneDrive\\\\Desktop\\\\Screenshot\\\\8.png");
		 FileUtils.copyFile(sourc, destination);
	}
}
