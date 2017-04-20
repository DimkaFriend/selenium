package Modul_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class GoodsPage extends Page {

    public GoodsPage(WebDriver driver) {
        super(driver);


    }


    private WebElement waitVisibleElement()
    {
        return wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.cssSelector(".quantity>button"))));
    }

    private Boolean countIsBasket()
    {
       int i = Integer.parseInt(this.driver.findElement(By.xpath(".//*[@id='cart']/a[2]/span[1]")).getText());
       return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".quantity"),Integer.toString(1+i)));
    }

    public GoodsPage addCartToBasket()
    {
        if(waitVisibleElement()!=null)
        {
            this.driver.findElement(By.cssSelector(".quantity>button")).click();
        }

        if(countIsBasket())
        {
            return this;
        }else
            {
                return null;
            }

    }

    public void toBack()
    {
        this.driver.navigate().to("http://localhost:81/lifecart/en/");
    }
}
