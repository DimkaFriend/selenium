package Modul_1_2_3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by boltenkov on 17.03.2017.
 */
public class TestEdge {
    private WebDriver driver;


    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new EdgeDriver(caps);
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
