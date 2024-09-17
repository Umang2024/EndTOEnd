package Selenium.SeleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	public WebDriver intializeDriver() throws IOException {
		String path = "C:\\Users\\umang\\eclipse-workspace\\SeleniumPractice\\src\\main\\java\\Resources\\browserDetails.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);

		String browser = prop.getProperty("browser");

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;

	}

	public LandingPage goToURL() throws IOException {
		driver = intializeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		LandingPage landingPage = new LandingPage(driver);
		return landingPage;

	}

}
