package Modul_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class MainPage extends Page {
    private String pageURL;
    public MainPage(WebDriver driver,String pageURL) {
        super(driver);
        this.pageURL=pageURL;
    }

    public MainPage openPage()
    {
        this.driver.get(pageURL);
        return this;
    }

    public void openCart()
    {
        this.driver.findElement(By.cssSelector(".product.column.shadow.hover-light")).click();
    }

}
