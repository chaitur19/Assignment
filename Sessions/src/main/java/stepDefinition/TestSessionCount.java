package stepDefinition;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSessionCount {

WebDriver driver;

String clickSessionsValue;
String hoverSessionsValue;
@Given("^I launch highcharts homepage$")
public void i_launch_highcharts_homepage() throws Throwable {
	File file = new File("C:\\Users\\msrik\\Desktop\\Molecular\\Sessions\\phantomjs.exe");				
    System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
    driver = new PhantomJSDriver();

    //Run in chrome driver to see actual functionality
    /*System.setProperty("webdriver.chrome.driver","C:\\Users\\msrik\\Desktop\\Selenium\\Workspace\\chromedriver.exe");
	driver = new ChromeDriver();*/
    
	driver.manage().window().maximize();
	driver.get("https://www.highcharts.com/demo/line-ajax");
}

@When("^I hover on Jan 5th 2018 sessions point$")
public void i_hover_on_Jan_th_sessions_point() throws Throwable {
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement svgObj = driver.findElement(By.xpath("//*[name()='path' and @fill='#434348'][19]"));
	System.out.println("hello");
	Actions actionBuilder = new Actions(driver);
	actionBuilder.moveToElement(svgObj).perform();
	Thread.sleep(5000);
	actionBuilder.click(svgObj).build().perform();
}

@When("^I Store sessions Count value$")
public void i_Store_sessions_Count_value() throws Throwable {
	hoverSessionsValue = driver.findElement(By.xpath("//*[name()='text' and @x='8']//*[7]")).getText();
	System.out.println(hoverSessionsValue);
}

@When("^I click on Jan 5th 2018 sessions point$")
public void i_click_on_Jan_th_sessions_point() throws Throwable {
    Thread.sleep(5000);
    clickSessionsValue = driver.findElement(By.xpath("//div[@class='highslide-maincontent' and text()=' 47.936 sessions']")).getText();
    System.out.println(clickSessionsValue);
}

@Then("^I should see the same sessions count value$")
public void i_should_see_the_same_sessions_count_value() throws Throwable {
     Thread.sleep(5000);
     assert clickSessionsValue.contains(hoverSessionsValue);
     driver.quit();
}

}
