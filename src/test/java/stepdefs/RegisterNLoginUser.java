package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class RegisterNLoginUser {
    WebDriver driver;
    WebElement UserName;
    String FirstNameText,LastNameText;
    @Given("User should be able to navigate to homepage")
    public void user_should_be_able_to_navigate_to_homepage() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://elearningm1.upskills.in/");
        Thread.sleep(10000);
    }

    @When("User click on the signup link")
    public void user_click_on_the_signup_link() {
        // Write code here that turns the phrase above into concrete actions
          driver.findElement(By.xpath("//a[contains(text(),'Sign up!')]")).click();
    }

    @When("User enters mandatory details and click Signup button")
    public void user_enters_mandatory_details_and_click_Signup_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement FirstName = driver.findElement(By.xpath("//input[@id='registration_firstname']"));
        FirstNameText =randomNameGenerator();
        FirstName.sendKeys(FirstNameText);
        WebElement LastName = driver.findElement(By.xpath("//input[@id='registration_lastname']"));
        LastNameText = randomNameGenerator();
        LastName.sendKeys(LastNameText);
        driver.findElement(By.xpath("//input[@id='registration_email']")).sendKeys("sathyavani1@gmail.com");
        UserName= driver.findElement(By.xpath("//input[@id='username']"));
        UserName.sendKeys(randomNameGenerator());
        driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("Sathya");
        driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys("Sathya");
        driver.findElement(By.xpath("//button[@id='registration_submit']")).click();
    }

    @Then("User should be registered and loggedin")
    public void user_should_be_registered_and_loggedin() {
        String nametext = driver.findElement(By.xpath("//div[@class='row']/div/p[1]")).getText();
        System.out.println(nametext);
        String expected = "Dear "+FirstNameText+" "+LastNameText;
        System.out.println(expected);
        assertTrue(nametext.contains(expected));
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        driver.findElement(By.xpath("//a[@id='logout_button']")).click();
        driver.close();
    }

    public String randomNameGenerator() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        String name=sb.toString();
        return name;
    }

}
