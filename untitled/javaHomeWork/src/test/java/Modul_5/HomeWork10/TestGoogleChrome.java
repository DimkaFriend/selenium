package Modul_5.HomeWork10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by boltenkov on 17.03.2017.
 */
public class TestGoogleChrome {
    private WebDriver driver;


    @Before
    public void start()
    {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour","ignore");
        this.driver= new ChromeDriver(caps);
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

    @Test
    public void stepClickAllPointMenu()
    {

        /*"ul>li.product"
        * "ul>li.product>a>div.name
        * ".price"
        * ".price-wrapper"
        * ".regular-price"
        * ".regular-price"
        * ".regular-price"*/
        String title="";
        String priceUsual="";
        String[] priceUsualColor={};
        String priceUsualStyleText="line-through";
        String pricePromotional="";
        String[] pricePromotionalColor={};
        String pricePromotionalStyleText="bold";
        this.driver.get("http://localhost:81/lifecart/en/");

        if(this.driver.findElements(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]"))!=null)
        {
            title = this.driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]")).findElement(By.cssSelector(".name")).getText();
            priceUsual = this.driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]")).findElement(By.cssSelector(".regular-price")).getText();
            pricePromotional = this.driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]")).findElement(By.cssSelector(".campaign-price")).getText();

            priceUsualColor= this.driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color").substring(5,17).split(", ");
            pricePromotionalColor =this.driver.findElement(By.cssSelector(".regular-price")).getCssValue("color").substring(5,18).split(", ");
System.out.println("Главная форма");
            if((priceUsualStyleText.equals(this.driver.findElement(By.tagName("s")).getCssValue("text-decoration-line")))&&
                    (pricePromotionalStyleText.equals(this.driver.findElement(By.tagName("strong")).getCssValue("font-weight"))))
            {
                System.out.println("Цены имеют нужный стиль");
            }



            if(Float.parseFloat(this.driver.findElement(By.tagName("s")).getCssValue("font-size").split("p")[0])<Float.parseFloat(this.driver.findElement(By.cssSelector(".price-wrapper")).getCssValue("font-size").split("p")[0]))
            {
                System.out.println("Размер цены акции больше размера цены  начальной");
            }


        }
        this.driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]")).click();


        System.out.println("Форма товара");

        if((title.equals(this.driver.findElement(By.cssSelector("h1.title")).getText().toString()))
                &&
                ((priceUsual.equals(this.driver.findElement(By.cssSelector(".regular-price")).getText().toString()))
                        &&(pricePromotional.equals(this.driver.findElement(By.cssSelector(".campaign-price")).getText())))
                )
        {
            System.out.println("Текст и цены совпали");
        }

       if((priceUsualStyleText.equals(this.driver.findElement(By.tagName("s")).getCssValue("text-decoration-line")))&&
            (pricePromotionalStyleText.equals(this.driver.findElement(By.tagName("strong")).getCssValue("font-weight"))))
        {
            System.out.println("Цены имеют нужный стиль");
        }

        if(Float.parseFloat(this.driver.findElement(By.tagName("s")).getCssValue("font-size").split("p")[0])<Float.parseFloat(this.driver.findElement(By.cssSelector(".price-wrapper")).getCssValue("font-size").split("p")[0]))
        {
            System.out.println("Размер цены акции больше размера цены  начальной");
        }




    }

    @After
    public void stop()
    {
        this.driver.quit();
        this.driver = null;
    }
}
