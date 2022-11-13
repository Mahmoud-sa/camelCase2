package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	static WebDriver driver;
	String Url = "https://treats.asuvh.com";

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\Project\\Project1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();

	}

	public static WebDriver get_web_driver() {
		return driver;

	}

}
