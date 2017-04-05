package Modul_4.HomeWork8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

/**
 * Created by boltenkov on 24.03.2017.
 */
public class TestEdge {
    private WebDriver driver;


    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new EdgeDriver(caps);
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
