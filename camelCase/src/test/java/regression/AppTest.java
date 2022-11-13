package regression;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest {

//@Parameters({"username"})

	@BeforeTest
	public void open_browser() {
		BaseClass bc = new BaseClass();
		bc.setup();

	}

	@Test(priority = 1)
	public void test_login_missing_password() {

		WebElement email_Input = BaseClass.get_web_driver().findElement(By.name("email"));
		// send Email
		email_Input.sendKeys("automator@camelcasetech.com");

		WebElement password_Input = BaseClass.get_web_driver().findElement(By.name("password"));
		// send password
		password_Input.sendKeys("");

		WebElement login_button = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/form/div/form/div[3]/div[1]/button"));
		login_button.click();

		String missing_password_text = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/span")).getText();
		assertEquals(missing_password_text, "The password field is required.");

		email_Input.clear();

		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 2)
	public void test_login_missing_Email() {
		WebElement email_Input = BaseClass.get_web_driver().findElement(By.name("email"));
//		//send Email
		email_Input.sendKeys("");
//		
		WebElement password_Input = BaseClass.get_web_driver().findElement(By.name("password"));
		// send password
		password_Input.sendKeys("1223568");
//		
		WebElement login_button = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/form/div/form/div[3]/div[1]/button"));
		login_button.click();
//		
//
		String missing_email_text = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/span")).getText();
		assertEquals(missing_email_text, "The email field is required.");
//		
	}
//	

	// Read data from excel sheet for login
	@DataProvider(name = "ExcelData")
	public Object[][] Data_login() throws IOException, Exception {
		ExcelData ER = new ExcelData();
		return ER.read_user_data();
	}

	@Test(priority = 3, dataProvider = "ExcelData")
	public void test_login(String email, String password) {

//		
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement email_Input = BaseClass.get_web_driver().findElement(By.name("email"));
		// send Email
		email_Input.sendKeys(email);
		WebElement password_Input = BaseClass.get_web_driver().findElement(By.name("password"));
		// send password
		password_Input.sendKeys(password);
		// click button
		WebElement login_button = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[1]/form/div/form/div[3]/div[1]/button"));
		login_button.click();
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		email_Input.clear();
		password_Input.clear();
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// put write data static
		email_Input.sendKeys("automator@camelcasetech.com");
		password_Input.sendKeys("987654321");
		login_button.click();

	}

	@Test(priority = 4)

	public void leave_right_field_add_country() throws Exception {
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("in add new city link");

		WebElement cities_link = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li/a"));
		cities_link.click();
		WebElement List = BaseClass.get_web_driver().findElement(By.linkText("List"));
		List.click();

		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Click on new city Button
		WebElement new_city_Btn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[1]/div[2]/a"));
		new_city_Btn.click();

		// test case _1 I will put one English inputs
		WebElement en_city_name = BaseClass.get_web_driver().findElement(By.id("name"));
		en_city_name.sendKeys("aswan");

		Select country = new Select(BaseClass.get_web_driver().findElement(By.id("country_id")));

		for (int i = 0; i <= 3; i++) {
			System.out.println("chang country");
			country.selectByIndex(i);
		}
		// country.selectByVisibleText("yemen");
		// country.selectByVisibleText("Somalia");

		WebElement save_Btn = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/div/div/form/footer/div/div[1]/button"));
		save_Btn.click();

		// Thread.sleep(6000);
		BaseClass.get_web_driver().navigate().refresh();
	}

	@Test(priority = 5)

	public void leave_left_field_add_country() throws Exception {
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("in add new city link");

		WebElement cities_link = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li/a"));
		cities_link.click();
		WebElement List = BaseClass.get_web_driver().findElement(By.linkText("List"));
		List.click();

		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Click on new city Button
		WebElement new_city_Btn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[1]/div[2]/a"));
		new_city_Btn.click();

		// test case _1 I will put one English inputs
		WebElement en_city_name = BaseClass.get_web_driver().findElement(By.id("name"));
		en_city_name.sendKeys("aswan");

		Select country = new Select(BaseClass.get_web_driver().findElement(By.id("country_id")));

		for (int i = 1; i <= 3; i++) {

			country.selectByIndex(i);
			System.out.println(i);
		}

		WebElement save_Btn = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/div/div/form/footer/div/div[1]/button"));
		save_Btn.click();

		BaseClass.get_web_driver().navigate().refresh();
	}

	@Test(priority = 6, dataProvider = "ExcelDataCity")
	public void add_new_city(String en_city, String ar_city) throws Exception {
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("in add new city link");

		WebElement cities_link = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li/a"));
		cities_link.click();
		WebElement List = BaseClass.get_web_driver().findElement(By.linkText("List"));
		List.click();

		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Click on new city Button
		WebElement new_city_Btn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[1]/div[2]/a"));
		new_city_Btn.click();

		// test case _1 I will put two English inputs
		WebElement en_city_name = BaseClass.get_web_driver().findElement(By.id("name"));
		en_city_name.sendKeys(en_city);
		WebElement Ar_city_name = BaseClass.get_web_driver().findElement(By.id("name_ar"));
		Ar_city_name.sendKeys(ar_city); //
		Select country = new Select(BaseClass.get_web_driver().findElement(By.id("country_id")));
		country.selectByVisibleText("Egypt");
		// country.selectByVisibleText("Somalia");
		// country.selectByVisibleText("Yemen");

		WebElement save_Btn = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/div/div/form/footer/div/div[1]/button"));
		save_Btn.click();
	}

	// This method will help me to read data from another class for add new city
	@DataProvider(name = "ExcelDataCity")
	public Object[][] Data_city() throws IOException, Exception {
		ExcelData ERC = new ExcelData();

		return ERC.read_city_data();
	}

	@Test(priority = 7)
	public void updateCity() throws InterruptedException {

		Thread.sleep(2000);

		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("BEFORE");

		// WebElement listBtn =
		// BaseClass.get_web_driver().findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/ul/li/ul/li/a"));
		// listBtn.click();

		WebElement pagetionpage = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[2]/div/div/div/nav/ul/li[5]/a"));
		pagetionpage.click();
		System.out.println("clicked on pagantian");

		// I clicked here on 3dots Button its button in city filed to help me to edit or
		// delete the city
		WebElement ThreeDotsBtn = BaseClass.get_web_driver().findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[2]/div/div/div/div[2]/table/tbody/tr[7]/td[2]/div/button"));
		ThreeDotsBtn.click();

		// System.out.println("inupadte_city");

		// i waiting here for 5 second to avoid "No such element"
		BaseClass.get_web_driver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// click Edit button
		WebElement EditeBtn = BaseClass.get_web_driver().findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[2]/div/div/div/div[2]/table/tbody/tr[7]/td[2]/div/div/a[1]"));
		EditeBtn.click();

		WebElement NameEnInput = BaseClass.get_web_driver().findElement(By.id("name"));

		// delete old value using function clear
		NameEnInput.clear();

		// write new value in English field
		NameEnInput.sendKeys("Bani Suwayf");

		WebElement SaveBtn = BaseClass.get_web_driver().findElement(
				By.xpath("//*[@id=\"root\"]/div/div[2]/div/main/div/div/div/div/div/form/footer/div/div[1]/button"));
		SaveBtn.click();

	}

	@Test(priority = 8)
	public void delete() {
		System.out.println(" delete");
		WebElement dotsbTN = BaseClass.get_web_driver().findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div/button"));
		dotsbTN.click();
		WebElement deleteBtn = BaseClass.get_web_driver().findElement(By.xpath(
				"//*[@id=\"root\"]/div/div[2]/div/main/div/div/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[2]/div/div/a[2]"));
		deleteBtn.click();

		WebElement yesBtn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"react-confirm-alert\"]/div/div/div/div/button[1]"));
		yesBtn.click();

	}

	@Test(priority = 9)
	public void signout() {

		System.out.println("signout");

		WebElement profileBtn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/header/ul[2]/li[2]/a"));
		profileBtn.click();

		WebElement signoutBtn = BaseClass.get_web_driver()
				.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/header/ul[2]/li[2]/div/a[2]"));
		signoutBtn.click();
	}

	@AfterTest

	public void closedriver() {
		BaseClass.get_web_driver().close();

	}
}
