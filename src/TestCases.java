import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	WebDriver driver = new ChromeDriver();
	String WebSite = "https://codenboxautomationlab.com/practice";
	Random rand = new Random();

	@BeforeTest
	public void SetUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get(WebSite);

	}

	@Test(priority = 1, enabled = true)

	public void RadioButton() {

		WebElement RButton = driver.findElement(By.id("radio-btn-example"));
		RButton.findElements(By.tagName("input"));

		int RndomInput = RButton.findElements(By.tagName("input")).size();
		int RandomInput = rand.nextInt(RndomInput);

		WebElement SelectInput = RButton.findElements(By.tagName("input")).get(RandomInput);
		SelectInput.click();

		boolean ActualResult = SelectInput.isSelected();
		boolean ExpectedResult = true;
		Assert.assertEquals(ActualResult, ExpectedResult);

	}

	@Test(priority = 2, enabled = true)
	public void DynamicButton() throws InterruptedException {

		String[] Characters = { "AB", "AC", "EA", "Op" };

		int RandomIndex = rand.nextInt(Characters.length);

		String CharactersInput = Characters[RandomIndex];

		WebElement AutocompleteInput = driver.findElement(By.id("autocomplete"));
		AutocompleteInput.sendKeys(CharactersInput);
		Thread.sleep(2000);

		AutocompleteInput.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 3, enabled = true)
	public void StaticButton() {

		WebElement StaticInput = driver.findElement(By.id("dropdown-class-example"));

		Select selector = new Select(StaticInput);
		int RStatic = rand.nextInt(1, 4);
		selector.selectByIndex(RStatic);

	}

	@Test(priority = 4, enabled = true)
	public void CheckBox() {
		WebElement CheckInput = driver.findElement(By.id("checkbox-example"));

		List<WebElement> CheckInbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (int i = 0; i < CheckInbox.size(); i++) {

			CheckInbox.get(i).click();

		}

	}

	@Test(priority = 5, enabled = false)
	public void SwitchWindow() throws InterruptedException {
		WebElement SwitchInput = driver.findElement(By.id("openwindow"));
		SwitchInput.click();

		List<String> WindowHandles = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(WindowHandles.get(1));
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".ct-menu-item")).click();

		driver.switchTo().window(WindowHandles.get(0));

	}

	@Test(priority = 6, enabled = false)
	public void OpenTab() {

		WebElement OpenTabInput = driver.findElement(By.id("opentab"));

		OpenTabInput.click();
		List<String> WindowHandles = new ArrayList<>(driver.getWindowHandles());

		driver.switchTo().window(WindowHandles.get(1));

	}

	@Test(priority = 7, enabled = true)
	public void AlertTab() throws InterruptedException {

		WebElement AlertInput = driver.findElement(By.id("name"));
		AlertInput.sendKeys("soso");

		// driver.findElement(By.id("alertbtn")).click();

		// driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		boolean ActualResult3 = driver.switchTo().alert().getText().contains("soso");
		boolean ExpectedResult3 = true;

		driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();
	}

	@Test(priority = 8, enabled = true)
	public void WebTable() {

		WebElement TableInput = driver.findElement(By.id("product"));

		List<WebElement> AllPrices = TableInput.findElements(By.tagName("td"));

		for (int i = 2; i < AllPrices.size(); i = i + 3) {
			AllPrices.get(i).getText();

			System.out.print(AllPrices.get(i).getText());
		}

	}

	@Test(priority = 9, enabled = true)
	public void Element() {
		WebElement HideButton = driver.findElement(By.id("hide-textbox"));
		HideButton.click();

		WebElement ShowButton = driver.findElement(By.id("show-textbox"));
		ShowButton.click();

		WebElement SHOW = driver.findElement(By.id("displayed-text"));
		SHOW.sendKeys("SAWSAN");

		boolean ActualResult4 = SHOW.isDisplayed();
		boolean ExpectedResult4 = true;
		Assert.assertEquals(ActualResult4, ExpectedResult4);

	}

	@Test(priority = 10, enabled = true)
	public void EnabledDisabled() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1500)");

		WebElement DisabledInput = driver.findElement(By.id("disabled-button"));
		DisabledInput.click();
		Thread.sleep(1000);

		WebElement EnabledInput = driver.findElement(By.id("enabled-button"));
		EnabledInput.click();

		WebElement NameInput = driver.findElement(By.id("enabled-example-input"));
		NameInput.sendKeys("soso");

	}

	@Test(priority = 11, enabled = true)
	public void MouseHoover() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,1750)");

		WebElement MouseInput = driver.findElement(By.id("mousehover"));

		Actions action = new Actions(driver);
		action.moveToElement(MouseInput).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Reload")).click();

	}

	@Test(priority = 12,enabled=false)
	public void Calender() throws InterruptedException {
		
		driver.findElement(By.linkText("Booking Calendar")).click();

	List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

driver.switchTo().window(windowHandles.get(1));

	Thread.sleep(3000);

		for (int i = 1; i < 25; i++) {
			List<WebElement> AllCalender = driver.findElements(By.xpath("//a[@href='javascript:void(0)']"));
			AllCalender.get(i).click();
			Thread.sleep(1000);
		}
		
	}
	
	

	@Test(priority = 13)
	public void Iframe() throws InterruptedException {
//		JavascriptExecutor js = (JavascriptExecutor)driver ; 
//		
//		js.executeScript("window.scrollTo(0,2400)");
//		
//		WebElement MyFrame = driver.findElement(By.id("courses-iframe"));
//		Thread.sleep(2000);
//		
//		driver.switchTo().frame(MyFrame);
//		
//		js.executeScript("window.scrollTo(0,1100)");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//*[@id=\"ct_button-20c391b5\"]/a/span[2]")).click();
//		

	}

}
