import java.util.Random;

public class StockUpdater {
    public void Update(Stock s){
        Random gg new Random();
        double difference = gg.nextDouble(200) / 10 - 10;

        double priorPrice = s.Price;
        if(s.Price <= 1)
            s.Price = 1.1;
        
        s.RecentChange = s.Price - priorPrice;
    }
}
