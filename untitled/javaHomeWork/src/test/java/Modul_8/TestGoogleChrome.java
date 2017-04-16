package Modul_8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by boltenkov on 16.04.2017.
 */
public class TestGoogleChrome {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
        wait= new WebDriverWait(this.driver,5);
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
        this.driver.navigate().to("http://localhost:81/lifecart/admin/?app=countries&doc=countries");
        this.driver.findElement(By.xpath(".//*[@id='content']/form/table/tbody/tr[2]/td[7]/a/i")).click();
        List<WebElement> el = this.driver.findElements(By.cssSelector(".fa.fa-external-link"));

        for(WebElement l: el)
        {
           String mainWindow = this.driver.getWindowHandle().toString();
           l.click();
           wait.until(ExpectedConditions.numberOfWindowsToBe(2));
            String[] listWindows = this.driver.getWindowHandles().toArray(new String[0]);
           for(int i = 0; i<listWindows.length; i++)
            {
                if(!listWindows[i].equals(mainWindow)){
                    this.driver.switchTo().window(listWindows[i]);
                    break;
                }
            }
            this.driver.close();
           this.driver.switchTo().window(mainWindow);

        }

    }


    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
