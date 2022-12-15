import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchGoogle {
    WebDriver driver;
    @io.cucumber.java.en.Given("^I Open browser$")
    public void iOpenBrowser() {
        // final String dir = System.getProperty("user.dir");
        // System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", "C:\\sqa\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @io.cucumber.java.en.And("^Open website Google$")
    public void openWebsiteGoogle() throws InterruptedException {
        driver.get("https://www.google.co.id/");
        Thread.sleep(1000);
    }

    @io.cucumber.java.en.And("^Located on google website$")
    public void locatedOnGoogleWebsite() {
        driver.findElement(By.name("btnK")).isDisplayed();
    }

    @io.cucumber.java.en.When("^I search \"([^\"]*)\"$")
    public void iSearch(String searchValue) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("q")).sendKeys(searchValue, Keys.ENTER);
    }

    @io.cucumber.java.en.Then("^Showing result related with \"([^\"]*)\"$")
    public void showingResultRelatedWith(String arg0)  {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//a[@href='https://id.linkedin.com/in/wisnuwm']")).isDisplayed();
        String urlLinkedinWisnu = driver.findElement(By.xpath("//a[@href='https://id.linkedin.com/in/wisnuwm']")).getText();
        System.out.println(urlLinkedinWisnu);
        driver.close();
        driver.quit();
    }
}
