public class Stock {
    public String ShortName;
    public String FullName;
    public double Price;
    public double RecentChange;

    public Stock(String shorter, String full, double price){
        FullName = full;
        ShortName = shorter;
        Price = price;
        RecentChange = 0;
    }

    public void Display(){
        String priceFormatted = String.valueOf(Price);
        String recentChangeFormatted;

        if(RecentChange > 0)
        {
            recentChangeFormatted = "+" + RecentChange;
        } 
        else
        {
            recentChangeFormatted = String.valueOf(RecentChange);
        }

        System.out.printf(">> {0} - {1} - {2} ({3})", ShortName, FullName, priceFormatted, recentChangeFormatted);
    }
}
