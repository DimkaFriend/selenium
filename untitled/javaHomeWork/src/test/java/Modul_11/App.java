package Modul_11;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by boltenkov on 19.04.2017.
 */
public class App {

    private WebDriver driver;

    private MainPage mainPage;
    private GoodsPage goodsPage;
    private BasketPage basketPage;

    public App() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver,"http://localhost:81/lifecart/en/");
        goodsPage = new GoodsPage(driver);
        basketPage = new BasketPage(driver,"http://localhost:81/lifecart/en/checkout");
    }

   public void workWithTheBasket()
   {
        for(int i = 0 ; i < 3 ; i++)
        {
            mainPage.openPage().openCart();
            goodsPage.addCartToBasket().toBack();
        }


        basketPage.open().stopAnimation();

        for(;;)
        {
            try
            {
                basketPage.visibleRemove().deleteCart();
            }catch(NoSuchElementException e)
            {
                System.out.println("Basket is empty");
            }
        }
   }

    public void quit() {
        driver.quit();
    }
}
