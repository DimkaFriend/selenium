package Modul_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class BasketPage extends Page {
    private String pageURL;
    public BasketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        this.driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
    }

   public BasketPage open()
   {
       this.driver.navigate().to("http://localhost:81/lifecart/en/checkout");
       return this;
   }
    public void stopAnimation()
   {
       if(this.driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[1]/a")).isDisplayed())
       {
           this.driver.findElement(By.xpath(".//*[@id='box-checkout-cart']/ul/li[1]/a")).click();
       }
   }

   public BasketPage visibleRemove()
   {
       wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".item>form>div>p>button[value='Remove']"),"Remove"));
       return this;
   }

   public void deleteCart()
   {
       this.driver.findElement(By.cssSelector(".item>form>div>p>button[value='Remove']")).click();
   }

}
