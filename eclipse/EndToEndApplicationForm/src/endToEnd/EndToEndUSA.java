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

public class EndToEndUSA {
	
	//declaring driver object globally
	public static WebDriver driver;
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		//Chrome driver location
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Sruthi.Kundoor//Desktop//Automation updated//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		//URL to launch the webpage
		
		driver.get("https://apply-test.intostudy.com");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Assertion for course selector page
		Assert.assertEquals("https://apply-test.intostudy.com/course-selector", driver.getCurrentUrl());
		
		//select country
		
		driver.findElement(By.cssSelector("img[class='flag'][src='../assets/flags/flag-us.svg']")).click();
		Assert.assertEquals("US", driver.findElement(By.xpath("//div[@class='country-text country-text--selected'][text()='US']")).getText());
		
		//Entering subject in search area
		
		driver.findElement(By.name("searchTerm")).click();
		driver.findElement(By.name("searchTerm")).sendKeys("social");
		driver.findElement(By.name("searchTerm")).sendKeys(Keys.ENTER);
		
		//Selecting level
		
		driver.findElement(By.id("Undergraduate")).click();
		Assert.assertEquals("Pathway course leading to Undergraduate e.g. BA (Hons), BSC (Hons)", driver.findElement(By.xpath("//label[@class='radio-container']")).getText());
		
		//Selecting yes option for universities
		
		driver.findElement(By.cssSelector("label[for= 'Yes']")).click();
		driver.findElements(By.className("uni-list-item")).get(0).click();
		
		//click on show courses buton
		
		driver.findElement(By.cssSelector(".btn.btn-primary.search-button")).click();
		
		//Assertion for search results
		
		String actual = driver.findElement(By.cssSelector(".col-xl-8.col-lg-8.col-md-9.pt-3.pb-3.course-name"))
				.getText();
		System.out.println(actual);
		String expected = "View course details";
		Assert.assertTrue(actual.contains(expected));
		
		//click on apply button
		driver.findElements(By.cssSelector(".btn.btn-primary.pull-right")).get(0).click();
		
		//Assertion for your program session
		
		Assert.assertTrue(driver.getCurrentUrl().contains("https://apply-test.intostudy.com/application/course"));
		
		//your program session
		
		WebElement date = driver.findElement(By.id("scheduledCourse.startDate"));
		Select startdate = new Select(date);
		startdate.selectByValue("01t3A000003g6khQAA");
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement university = driver.findElement(
				By.xpath("//div/app-form-item[3]/app-progression-selector-question/div/div/div/div[2]/div[2]/select"));
		Select progressionuniversity = new Select(university);
		progressionuniversity.selectByValue("Colorado State University");
		
		//Assertion for Progression university
		
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='Colorado State University']")).getText().contains("Colorado State University"));
		WebElement degree = driver.findElement(
				By.xpath("//div/app-form-item[3]/app-progression-selector-question/div/div/div/div[3]/div[2]/select"));
		Select progressiondegree = new Select(degree);
		progressiondegree.selectByValue("aCE3A000000TNirWAG");
		
		//Assertion for progression degree
		
		Assert.assertTrue(driver.findElement(By.xpath("//option[@value='aCE3A000000TNirWAG']")).getText().contains("Agricultural Education-B.S."));
		
		//for next button
		
		driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
			    
	    //About you session
			//Email address    
		driver.findElement(By.id("email")).sendKeys("sru@gmail.com");
		//Firstname
		driver.findElement(By.id("firstName")).sendKeys("sruthi");
		//Last name
		driver.findElement(By.id("lastName")).sendKeys("automation");
		//phone number
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
		//gender
		driver.findElement(By.id("gender_f")).click();
		//1st address components
		//Addressline 1
        driver.findElement(By.id("address.addressLine1")).sendKeys("Brighton");
        //Address line 2
		driver.findElement(By.id("address.addressLine2")).sendKeys("surrey");
		//Address line 3
		driver.findElement(By.id("address.addressLine3")).sendKeys("line3");
		//Town/city
		driver.findElement(By.id("address.towncity")).sendKeys("Brighton");
		//state/region
		driver.findElement(By.id("address.stateregion")).sendKeys("east croydon");
		//zipcode
		driver.findElement(By.id("address.zipcode")).sendKeys("rh6 8Gh");
		//country
		Select countryfield = new Select(driver.findElement(By.id("address.country")));
		countryfield.selectByVisibleText("India");
		
		//yes for 2nd address
		
		driver.findElement(By.xpath("//div/app-form-item[8]/app-section/fieldset/app-form-item-container/div/app-form-item[2]/app-boolean-question/div/div[2]/div/div/button")).click();
        Assert.assertEquals("I'd like my official visa documents mailed to another address", driver.findElement(By.id("itemquestion_isCorrespondenceAddressDifferent")).getText());
		
		//2nd address components
		
	    driver.findElement(By.id("correspondenceAddress.addressLine1")).click();
	    driver.findElement(By.id("correspondenceAddress.addressLine1")).sendKeys("Brighton");
	    driver.findElement(By.id("correspondenceAddress.addressLine2")).click();
	    driver.findElement(By.id("correspondenceAddress.addressLine2")).sendKeys("addressline2");
	    driver.findElement(By.id("correspondenceAddress.addressLine3")).click();
	    driver.findElement(By.id("correspondenceAddress.addressLine3")).sendKeys("addressline3");
	    driver.findElement(By.id("correspondenceAddress.towncity")).click();
	    driver.findElement(By.id("correspondenceAddress.towncity")).sendKeys("town");
	    driver.findElement(By.id("correspondenceAddress.stateregion")).click();
	    driver.findElement(By.id("correspondenceAddress.stateregion")).sendKeys("state");
	    driver.findElement(By.id("correspondenceAddress.zipcode")).click();
	    driver.findElement(By.id("correspondenceAddress.zipcode")).sendKeys("RH6 7HG");
	    Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		WebElement country= driver.findElement(By.id("correspondenceAddress.country"));
	    Select secondcountry=new Select(country);
	    secondcountry.selectByVisibleText("Andorra");
	    driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
	    
	    //Education History
	    
	    // What school or institution have you most recently attended?
	    
	    driver.findElement(By.id("currentInstitution")).click();
	    driver.findElement(By.id("currentInstitution")).sendKeys("JNTU");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='currentInstitution']")).getText().contains("What school or institution have you most recently attended?"));
	    
	   // What qualification will/did you receive here?
	    
	    driver.findElement(By.id("qualificationName")).click();
	    driver.findElement(By.id("qualificationName")).sendKeys("Qualification");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='qualificationName']")).getText().contains("What qualification will/did you receive here?"));
	    
	    //In the last four years, which other schools or institutions have you attended?
	    
	    driver.findElement(By.id("otherPastStudies")).click();
	    driver.findElement(By.id("otherPastStudies")).sendKeys("Past studies");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='otherPastStudies']")).getText().contains("In the last four years, which other schools or institutions have you attended?"));
	    
	    //English qualifications
	    
	    driver.findElement(By.xpath("//div/app-form-item[2]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.xpath("//div/app-form-item[2]/app-multiple-choice-question/div/div[2]/div/label[2]/span")).click();
	    Assert.assertEquals(driver.findElement(By.id("itemquestion_hasTakenEnglishTest")).getText(), "In the last two years, have you taken an English test?");
	    
	    // Standardized tests
	    
	    driver.findElement(By.xpath("//div/app-form-item[3]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.xpath("//div/app-form-item[3]/app-section/fieldset/app-form-item-container/div/app-form-item[2]/app-multiple-choice-question/div/div[2]/div/label[3]/span")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='standardAdmissionTest']")).getText().contains("Which standardized test have you taken?"));
	    
	    // Four months gap
	    
	    driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[2]/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.id("qualificationStudyingInUnaccountedGap")).click();
	    driver.findElement(By.id("qualificationStudyingInUnaccountedGap")).sendKeys("4months gap");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='qualificationStudyingInUnaccountedGap']")).getText().contains("What qualification will/did you receive there?"));
	    //Click on next butt
	    driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
	  
	    
	    
	    //Additional information
	    //education counsellor
	    
	    driver.findElement(By.xpath("//div/app-form-item[3]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.id("educationCounsellor")).click();
	    driver.findElement(By.id("educationCounsellor")).sendKeys("education counsellor");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='educationCounsellor']")).getText().contains("Please name the organisation of your education counsellor"));
	    
	    //Additional information
	    //Are you currently living or studying in the US?
	    
	    driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item/app-boolean-question/div/div[2]/div/div/button")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='currentlyInUs']")).getText().contains("Are you currently living or studying in the US?"));
	    
	    //Are you a US citizen or permanent resident?
	    driver.findElement(By.xpath("//div/app-form-item[2]/app-boolean-question/div/div[2]/div/div/button")).click();
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='usCitizen']")).getText().contains("Are you a US citizen or permanent resident?"));
	    
	    //Do you have dual citizenship?
	    driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[3]/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.id("dualCitizenshipInformation")).click();
	    driver.findElement(By.id("dualCitizenshipInformation")).sendKeys("Dual citizenship");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='dualCitizenshipInformation']")).getText().contains("Please list the countries for which you have dual citizenship"));
	    
	    //Will you be bringing any dependants with you?
	    driver.findElement(By.xpath("//div/app-form-item[4]/app-section/fieldset/app-form-item-container/div/app-form-item[5]/app-boolean-question/div/div[2]/div/div/button")).click();
	    driver.findElement(By.id("numberOfDependents")).click();
	    driver.findElement(By.id("numberOfDependents")).sendKeys("2");
	    Assert.assertTrue(driver.findElement(By.xpath("//label[@for='numberOfDependents']")).getText().contains("How many dependents will there be?"));
	    
	    //Next button
	    driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
	    
	    //Terms and Conditions
	    
	    driver.findElement(By.cssSelector("button.btn.btn-outline-secondary")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-outline-secondary")).click();
	    driver.findElement(By.cssSelector("button.btn.btn-outline-secondary")).click();
	    
	    //submit application button
	    driver.findElement(By.cssSelector("div.col.text-right > span.ng-star-inserted > button.btn.btn-primary")).click();
	    Thread.sleep(4000);
	    
	    //Assertion for post submission
	    
	    String Expectedurl="http://www.intostudy.com/apply/thank-you-for-applying-us";
		String Actualurl=driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(Expectedurl,Actualurl);
		driver.close();
	    
	}
}


