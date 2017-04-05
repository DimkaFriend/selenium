package Modul_4.HomeWork8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

/**
 * Created by boltenkov on 24.03.2017.
 */
public class TestFFRSE {
    private WebDriver driver;


    @Before
    public void start()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Tools\\geckodriver.exe");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE,false);
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new FirefoxDriver(new FirefoxBinary(new File("D:\\Mozilla_Firefox_RSE\\firefox.exe")),new FirefoxProfile(), caps);
        this.driver.manage().window().maximize();
    }

    @Test
    public void stickerOnProduct()
    {
        this.driver.get("http://localhost:81/lifecart");
        List<WebElement> product =  this.driver.findElements(By.cssSelector("li>a.link"));
        this.driver.findElements(By.cssSelector("li>a.link"))
                .forEach(WebElement->
                {
                    if(WebElement.findElements(By.cssSelector("li>a.link>div>div.sticker")).size()!=1)
                    {
                        new ArrayIndexOutOfBoundsException().printStackTrace();
                        System.out.println( WebElement.getLocation());
                    }
                });

    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
