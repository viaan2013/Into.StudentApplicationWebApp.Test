package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UKEnglishStepDef {
	public static WebDriver driver;
	
	@Given("^I am in course selector page$")
	public void I_am_in_course_selector_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Sruthi.Kundoor//Desktop//Automation updated//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://apply-test.intostudy.com");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	   
	}

	@Given("^I select \"([^\"]*)\"$")
	public void I_select(String Country) throws Throwable {
		
		driver.findElement(By.cssSelector("img[class='flag'][src='../assets/flags/flag-" + Country + ".svg']")).click();
	}

	@Given("^I click on English language course link$")
	public void I_click_on_English_language_course_link() throws Throwable {
		driver.findElement(By.linkText("English Language course")).click();
	   
	}

	@Given("^I select English \"([^\"]*)\"$")
	public void I_select_English(String type) throws Throwable {
		driver.findElement(By.cssSelector(type)).click();
		Assert.assertTrue(driver.findElements(By.className("radio-container")).get(0).getText().contains("Academic English"));
	  
	}

	@Given("^I select university option$")
	public void I_select_university_option() throws Throwable {
		driver.findElement(By.cssSelector("label[for='Yes']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("label[for='Yes']")).getText().contains("Select a University"));
	}

	@When("^I click on show courses button$")
	public void I_click_on_show_courses_button() throws Throwable {
		driver.findElement(By.cssSelector(".btn.btn-primary.search-button")).click();
	    
	}

	@Then("^I should see searchresults page$")
	public void I_should_see_searchresults_page() throws Throwable {
		
		String Actual= driver.findElement(By.xpath("//div[@id='course-selector-container']/div/div[2]/app-search/div/app-search-results/div/div/div[2]/div/div[2]/h4")).getText();
		System.out.println(Actual);
        Assert.assertTrue(Actual.contains("Unsure of what INTO Pathway is right for you?"));
        driver.close();
	   
	}
    }
