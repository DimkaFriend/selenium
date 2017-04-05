package Modul_5.HomeWork9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by boltenkov on 15.03.2017.
 */
public class TestFireFox {
    private WebDriver driver;


    @Before
    public void start()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE,true);
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new FirefoxDriver(caps);
    }

    @Test
    public void myFirst()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();


    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
