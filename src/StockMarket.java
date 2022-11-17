public class StockMarket {
    private Stock[] stockSet;
    private StockUpdater stockUpdater = new StockUpdater();

    public StockMarket(Stock[] stocks)
    {
        stockSet = stocks;
        stockUpdater = new StockUpdater();
    }

    public Stock[] GetAllStocks() 
    {
        return stockSet;
    } 

    public void UpdateSet()
    {
        for(Stock s : stockSet){
            stockUpdater.Update(s);
        }
    }
}
