package Modul_6.HomeWork11.HomeWork11.HomeWork12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by boltenkov on 02.04.2017.
 */
public class testgoogle {
    WebDriver driver;

    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
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

        this.driver.findElements(By.cssSelector("#app->a")).get(1).click();
        this.driver.findElements(By.cssSelector(".button")).get(1).click();
        this.driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>label")).get(0).click();
        this.driver.findElements(By.cssSelector(".input-wrapper>input")).get(0).sendKeys("DuckU");
        this.driver.findElement(By.cssSelector("#tab-general>table>tbody>tr>td>input")).sendKeys("01");

        new Actions(this.driver)
                .moveToElement(this.driver.findElements(By.cssSelector(".input-wrapper>table>tbody>tr>td>input")).get(1)).click()
                .moveToElement(this.driver.findElements(By.cssSelector(".input-wrapper>table>tbody>tr>td>input")).get(2)).click();
        this.driver.findElements(By.cssSelector(".input-wrapper>table>tbody>tr>td>input")).get(2).click();
        this.driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>table>tbody>tr>td>input")).get(0).sendKeys("1");
        this.driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>table>tbody>tr>td>input")).get(1).sendKeys("C:\\Users\\boltenkov\\Dropbox\\selenium\\untitled\\javaHomeWork\\src\\test\\java\\Modul_6\\HomeWork11\\HomeWork11\\HomeWork12\\i.jpg");
        this.driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>input")).get(1).sendKeys("02-04-2017");
        this.driver.findElements(By.cssSelector("#tab-general>table>tbody>tr>td>input")).get(2).sendKeys("02-04-2018");
        this.driver.findElements(By.cssSelector(".index>li>a")).get(1).click();

        new Select(this.driver.findElement(By.cssSelector("#tab-information>table>tbody>tr>td>select"))).selectByIndex(1);
        this.driver.findElement(By.cssSelector("#tab-information>table>tbody>tr>td>input")).sendKeys("DuckU");
        this.driver.findElements(By.xpath(".//*[@id='tab-information']//input")).get(0).sendKeys("DuckU");

        this.driver.findElements(By.cssSelector(".trumbowyg-editor")).get(0).sendKeys("DuckU");

        this.driver.findElements(By.xpath(".//*[@id='tab-information']//input")).get(1).sendKeys("DuckU");
        this.driver.findElements(By.xpath(".//*[@id='tab-information']//input")).get(2).sendKeys("DuckU");

        this.driver.findElements(By.cssSelector(".index>li>a")).get(3).click();

        this.driver.findElements(By.cssSelector("#tab-prices>table>tbody>tr>td>input")).get(0).sendKeys("10");
        new Select(this.driver.findElement(By.cssSelector("#tab-prices>table>tbody>tr>td>select"))).selectByIndex(1);

        this.driver.findElement(By.cssSelector(".button-set>button")).click();
        this.driver.get("http://localhost:81/lifecart/admin/?app=catalog&doc=catalog");
        for(int i = 0 ; i < this.driver.findElements(By.cssSelector(".button-set>button")).size();i++)
        {
            if(this.driver.findElements(By.cssSelector(".button-set>button")).get(i).getText()=="DuckU")
            {
                System.out.println("Товар добавлен");
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
