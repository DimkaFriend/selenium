package Modul_5.HomeWork10;

/**
 * Created by boltenkov on 27.03.2017.
 */
public class Dack {
    String name;
    int  priceUsual;
    int  pricePromotional;

    public Dack( String name,
            int  priceUsual,
            int  pricePromotional)
    {
        this.name= name;
        this.priceUsual=priceUsual;
        this.pricePromotional=pricePromotional;
    }

    public Dack( String name,
                 int  priceUsual)
    {
        this.name= name;
        this.priceUsual=priceUsual;
        this.pricePromotional=0;
    }

    public String getName() {
        return name;
    }

    public int getPriceUsual() {
        return priceUsual;
    }

    public int getPricePromotional() {
        return pricePromotional;
    }
}
