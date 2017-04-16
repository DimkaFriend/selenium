package Modul_7.HomeWork13;

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

/**
 * Created by boltenkov on 06.04.2017.
 */
public class test {
    WebDriver driver;
    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
    }

    @Test
    public void Cart()
    {
        this.driver.get("http://localhost:81/lifecart/en/");
        for(int i = 0; i < 3; i ++)
        {
            WebDriverWait wait = new WebDriverWait(this.driver,30);
            WebElement item = this.driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]"));
            this.driver.findElement(By.cssSelector(".product.column.shadow.hover-light")).click();
            this.driver.findElement(By.cssSelector(".quantity>button")).click();

            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(item)));
            System.out.println(this.driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]")).getText());
            this.driver.navigate().back();

        }
        System.out.println(this.driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]")).getText());
        this.driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
        //контрол таблицы .dataTable.rounded-corners>tbody
        //контрол кнопки .item>form>div>p>button[value='Remove']
        for(int i = 0; i < 3; i ++)
        {
        WebDriverWait wait = new WebDriverWait(this.driver,30);
        wait.until(ExpectedConditions.stalenessOf(this.driver.findElement(By.cssSelector(".dataTable.rounded-corners"))));
        this.driver.findElement(By.cssSelector(".item>form>div>p>button[value='Remove']")).click();

        }
    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}