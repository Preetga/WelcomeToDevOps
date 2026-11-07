import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocalLoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        String page = new File("webpage/login.html")
                .getAbsoluteFile()
                .toURI()
                .toString();

        driver.get(page);
    }

    @Test
    public void pageTitleIsWelcomeToDevOps() {
        Assert.assertEquals(driver.getTitle(), "Welcome to DevOps");
    }

    @Test
    public void headingDisplaysWelcomeToDevOps() {
        String heading = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(heading, "Welcome to DevOps");
    }

    @Test
    public void pageLanguageIsEnglish() {
        String language = driver.findElement(By.tagName("html"))
                .getAttribute("lang");
        Assert.assertEquals(language, "en");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}