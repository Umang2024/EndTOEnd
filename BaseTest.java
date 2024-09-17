package Selenium.SeleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	static WebDriver driver;

	static WebDriver intializeDriver() throws IOException {
		Properties prop = new Properties();
		String filePath = System.getProperty("user.dir")
				+ "\\src\\main\\java\\Selenium\\SeleniumPractice\\a.properties";
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);

		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		return driver;
	}
	
	public LandingPage goToURL() throws IOException {
	driver =	intializeDriver();
	driver.get("https://rahulshettyacademy.com/client");
	}

}
