package com.stepdefinition;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CourseselectorStepDef {
	
	public static  WebDriver driver;

	@Given("^I am in CourseSelectorHomepage$")
	public void i_am_in_CourseSelectorHomepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Sruthi.Kundoor//Desktop//Automation updated//chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://apply-test.intostudy.com");
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@When("^I Click and select \"([^\"]*)\"$")
	public void i_Click_and_select(String country) throws Throwable {

		driver.findElement(By.cssSelector("img[class='flag'][src='../assets/flags/flag-" + country + ".svg']")).click();
	}

	@When("^I enter subject in \"([^\"]*)\" area$")
	public void i_enter_subject_in_area(String subject) throws Throwable {
		driver.findElement(By.name("searchTerm")).click();
		driver.findElement(By.name("searchTerm")).sendKeys(subject);

	}

	@When("^I click on Add subject button$")
	public void i_click_on_Add_subject_button() throws Throwable {
		// driver.findElement(By.className("btn.btn-primary")).click();
		driver.findElement(By.name("searchTerm")).sendKeys(Keys.ENTER);
	}

	@When("^I select \"([^\"]*)\"of study$")
	public void i_select_of_study(String level) throws Throwable {

		driver.findElement(By.id(level)).click();
	}

	@When("^I should see Universities information which is \"([^\"]*)\"$")
	public void i_should_see_Universities_information_which_is(String optional) throws Throwable {

		driver.findElement(By.cssSelector("label[for= " + optional + "]")).click();
	}

	@When("^I select \"([^\"]*)\" from list$")
	public void i_select_from_list(String University) throws Throwable {

		driver.findElements(By.className(University)).get(0).click();
	}

	@When("^I click on Show courses button$")
	public void i_click_on_Show_courses_button() throws Throwable {

		driver.findElement(By.cssSelector(".btn.btn-primary.search-button")).click();
		Thread.sleep(2000);

	}

	@Then("^I should see search results$")
	public void i_should_see_search_results() throws Throwable {

		String actual = driver.findElements(By.cssSelector(".col-xl-8.col-lg-8.col-md-9.pt-3.pb-3.course-name")).get(0).getText();
				
		System.out.println(actual);
		String expected = "View course details";
		Assert.assertTrue(actual.contains(expected));
	}

	
}
