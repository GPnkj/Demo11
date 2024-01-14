package StepDefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FBSteps {
	WebDriver driver;

	@Given("User open a {string} browser")
	public void user_open_a_browser(String string) {
		if (string.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\BusinessComputers.in\\Desktop\\chromedriver-win64");
			driver = new ChromeDriver();
		} else {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/reg/");

	}

	@Given("user will be on facebook page")
	public void user_will_be_on_facebook_page() {
		driver.getTitle();
		String a = driver.getCurrentUrl();
		boolean b = a.contains("facbook");
		System.out.println(b);
	}

	@When("user enter valid {string} , {string} , {string} , {string} ,")
	public void user_enter_valid(String string, String string2, String string3, String string4) {
		driver.findElement(By.name("firstname")).sendKeys(string);
		driver.findElement(By.name("lastname")).sendKeys(string2);
		driver.findElement(By.name("reg_email__")).sendKeys(string3);
		driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[5]")).sendKeys(string4);
	}

	@When("user select {string} , {string} , {string} and select {string} gender")
	public void user_select_and_select_gender(String date, String month, String year, String gender) {
		WebElement wb = driver.findElement(By.name("birthday_day"));
		Select sel = new Select(wb);
		sel.selectByVisibleText(date);

		WebElement wb1 = driver.findElement(By.name("birthday_month"));
		Select sel1 = new Select(wb1);
		sel1.selectByVisibleText(month);

		WebElement wb2 = driver.findElement(By.name("birthday_year"));
		Select sel2 = new Select(wb2);
		sel2.selectByVisibleText(year);

		List<WebElement> wb3 = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba']/child::label"));
		for (WebElement ls : wb3) {
			if (ls.getText().equalsIgnoreCase(gender)) {
				ls.click();
				break;
			}
		}
	}

}
