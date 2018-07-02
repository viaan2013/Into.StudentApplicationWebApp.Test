package endToEnd;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndUk {
	
	//declaration of driver object globally
	public static WebDriver driver;

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		//Chrome driver location
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Sruthi.Kundoor//Desktop//Automation updated//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		//URL to launch the Webpage
		
		driver.get("https://apply.intostudy.com");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Assertion for course selector page
		Assert.assertEquals("https://apply.intostudy.com/course-selector", driver.getCurrentUrl());
		
		//Selecting country
		driver.findElement(By.cssSelector("img[class='flag'][src='../assets/flags/flag-gb.svg']")).click();
		
		Assert.assertEquals("UK", driver.findElement(By.xpath("//div[@class='country-text country-text--selected'][text()='UK']")).getText());
		//Entering subject in search area
		driver.findElement(By.name("searchTerm")).click();
		driver.findElement(By.name("searchTerm")).sendKeys("social");
		driver.findElement(By.name("searchTerm")).sendKeys(Keys.ENTER);
		//level of course
		driver.findElement(By.id("Undergraduate")).click();
		Assert.assertEquals("Pathway course leading to Undergraduate e.g. BA (Hons), BSC (Hons)", driver.findElement(By.xpath("//label[@class='radio-container']")).getText());
		//yes for university option
		driver.findElement(By.cssSelector("label[for= 'Yes']")).click();
		//selecting university
		driver.findElements(By.className("uni-list-item")).get(0).click();
		//click on show courses button
		driver.findElement(By.cssSelector(".btn.btn-primary.search-button")).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		
		//click on apply button
	
		driver.findElement(By.xpath("//div[@id='course-selector-container']/div/div[2]/app-search/div/app-search-results/div/div/div[2]/div[2]/div/div/div[3]/button")).click();
		//Assertion for your program session
		Assert.assertTrue(driver.getCurrentUrl().contains("https://apply.intostudy.com/application/course"));
		
		//your program session
		
		WebElement date= driver.findElement(By.id("scheduledCourse.startDate"));
		Select startdate=new Select(date);
		startdate.selectByValue("01t3A000007GZtVQAW");
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement university= driver.findElement(By.xpath("//div/app-form-item[3]/app-progression-selector-question/div/div/div/div[2]/div[2]/select"));
		Select progressionuniversity=new Select(university);
	    progressionuniversity.selectByValue("City, University of London");
	    
	    //Assertion for Progression university
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='City, University of London']")).getText().contains("City, University of London"));
	  		
	    WebElement degree= driver.findElement(By.xpath("//div/app-form-item[3]/app-progression-selector-question/div/div/div/div[3]/div[2]/select"));
		Select progressiondegree=new Select(degree);
	    progressiondegree.selectByValue("aCE3A000000TNeAWAW");
	    //Assertion for Progression degree
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='aCE3A000000TNeAWAW']")).getText().contains("International Political Economy-BSc (Hons)"));
	    //click on next button
	    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	    
	    //About you session
	    //Email address
	    driver.findElement(By.id("email")).sendKeys("sruthitest@k.com");
	    //First name
		driver.findElement(By.id("firstName")).sendKeys("sruthi@11.06.18");
		//Last name
		driver.findElement(By.id("lastName")).sendKeys("Test@regression");
		//Phone number
		Select phone = new Select(driver.findElement(By.id("phone")));
		phone.selectByVisibleText("Antigua and Barbuda +1-268");
		driver.findElements(By.id("phone")).get(1).sendKeys("453246334654");
		//DOB
		driver.findElement(By.id("dateOfBirth_day")).sendKeys("20");
		Select month = new Select(driver.findElement(By.id("dateOfBirth_month")));
		month.selectByVisibleText("January");
		driver.findElement(By.id("dateOfBirth_year")).sendKeys("2000");
		//Nationality
		Select nationality = new Select(driver.findElement(By.id("nationality")));
		nationality.selectByVisibleText("India");
		//Gender
		driver.findElement(By.id("gender_f")).click();
        //Address questions
		//Address line 1
		driver.findElement(By.id("address.addressLine1")).sendKeys("Brighton");
		//Address line 2
		driver.findElement(By.id("address.addressLine2")).sendKeys("surrey");
		//Address line 3
		driver.findElement(By.id("address.addressLine3")).sendKeys("line3");
		//Town/city
		driver.findElement(By.id("address.towncity")).sendKeys("Brighton");
		//state/region
		driver.findElement(By.id("address.stateregion")).sendKeys("eastcroydon");
		//Zipcode
		driver.findElement(By.id("address.zipcode")).sendKeys("rh68Gh");
		//Country
		Select countryfield = new Select(driver.findElement(By.id("address.country")));
		countryfield.selectByVisibleText("India");
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_PAGE_DOWN);
		//Next button
		driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary"))
				.click();
		
		//Additional information session
		
		driver.findElement(By.xpath("//div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
		//funding
		driver.findElement(By.id("paymentMethod_familyfunded")).click();
		//education counsellor
		driver.findElement(By.xpath("//div/app-form-item[3]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
		driver.findElement(By.id("educationCounsellor")).click();
		driver.findElement(By.id("educationCounsellor")).sendKeys("education counsellor");
		//medical condition
		driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
		driver.findElement(By.id("medicalConditionOrDisability")).click();
		driver.findElement(By.id("medicalConditionOrDisability")).sendKeys("medical condition");
		//citizen and visa related questions
		driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[3]/app-boolean-question/div/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[4]/app-boolean-question/div/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[5]/app-boolean-question/div/div[2]/div/div/button")).click();
		driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
		
		//Terms and Conditions
		//I accept button
		driver.findElement(By.cssSelector("button.btn.btn-outline-secondary")).click();
		
		//submit my application button
		driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
		Thread.sleep(4000);
		
	    //post submission page
		String Expectedurl="http://www.intostudy.com/apply/thank-you-for-applying-uk";
		String Actualurl=driver.getCurrentUrl();
		System.out.println(Actualurl);
		Assert.assertEquals(Expectedurl,Actualurl);
		driver.close();

		}

}
