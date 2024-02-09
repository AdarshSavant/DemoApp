package StepDefinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepsDefination {


	static WebDriver driver;


	@Test(priority=0)
	@Given("User is on Home page after login")
	public void user_is_on_home_page_after_login() {

		driver = new ChromeDriver();

		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.findElement(By.id("username")).sendKeys("Adarsh");
		driver.findElement(By.id("password")).sendKeys("Savant");
		driver.findElement(By.id("log-in")).click();

	}
	@Test (priority = 1)
	@When ("Click on the Amount Button")
	public void Click_on_the_Amount_Button() {



		List <WebElement> beforeColnames = driver.findElements(By.xpath(
				"//table[@id='transactionsTable']/tbody/tr/td[5]"));


		List<Double> beforSortList=new ArrayList<>();
		List<Double> afterSortList=new ArrayList<>();

		for (int i=0; i<beforeColnames.size(); i++) { 


			String str=beforeColnames.get(i).getText().replaceAll("[\\s+a-zA-Z :]","");
			String StringVar=str.replaceAll(",", "");
			beforSortList.add(Double.parseDouble(StringVar));
		}
		Collections.sort(beforSortList);
		System.out.println("Before Sorted List-----"+beforSortList);


		driver.findElement(By.xpath("//th[@id='amount']")).click();

		List <WebElement> afterColnames = driver.findElements(By.xpath(
				"//table[@id='transactionsTable']/tbody/tr/td[5]"));

		System.out.
		println("-----------------------------After Sorting----------------------------------------");

		for (int i=0; i<afterColnames.size(); i++) { 


			String str=afterColnames.get(i).getText().replaceAll("[\\s+a-zA-Z :]","");
			String StringVar=str.replaceAll(",", "");
			afterSortList.add(Double.parseDouble(StringVar));
		}

		System.out.println("After Sorted List-----"+afterSortList);

		Assert.assertEquals(beforSortList, afterSortList,"Result is Expected and Sorting Working as Expected after clicking Amount button on home page");

	}





	@Test(priority=2)

	@Then("Close the browser") public void close_the_browser() {

		driver.close(); }

}
