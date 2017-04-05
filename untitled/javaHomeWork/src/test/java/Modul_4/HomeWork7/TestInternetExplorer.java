package Modul_4.HomeWork7;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by boltenkov on 24.03.2017.
 */
public class TestInternetExplorer {
    private WebDriver driver;


    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new InternetExplorerDriver(caps);
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
