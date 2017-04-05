package Modul_4.HomeWork7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

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
    }

    @Test
    public void stepClickAllPointMenu()
    {
        this.driver.get("http://localhost:81/lifecart/admin/");
        this.driver.findElement(By.name("username")).clear();
        this.driver.findElement(By.name("username")).sendKeys("admin");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("admin");
        this.driver.findElement(By.name("login")).click();
        int sizeLevelOne =this.driver.findElements(By.cssSelector("#app->a")).size();
        for(int i = 0; i < sizeLevelOne; i ++)
        {
            this.driver.findElements(By.cssSelector("#app->a")).get(i).click();
            if(this.driver.findElements(By.cssSelector("#app->ul>li>a>span.name")).size()!=0)
            {
                int  sizeLevelTwo =this.driver.findElements(By.cssSelector("#app->ul>li>a>span.name")).size();
                for(int j = 0; j < sizeLevelTwo; j ++)
                {
                    this.driver.findElements(By.cssSelector("#app->ul>li>a>span.name")).get(j).click();
                    System.out.println(this.driver.findElement(By.cssSelector("#content>h1")).getText().toString());
                }
                // System.out.println( this.driver.findElements(By.cssSelector("#app->a")).get(i).getText().toString()+" Список не  пуст "  +  this.driver.findElements(By.cssSelector("#app->ul>li>a>span.name")).size());
            }
        }
    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
