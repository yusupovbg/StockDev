public class App {
    public static StockMarket stockMarket;
    public static int roundCount;
    public static Portfolio portfolio;
    public static MainView mainView;
    public static AcquisitionView acquisitionView;
    public static ReleasementView releasementView;
    public static ContinueOrExitView continueOrExitView;
    public static void main(String[] args) throws Exception {
        
        Stock stocks[] = 
        {
            new Stock("oib", "Oibes & Co.", 133.2),
            new Stock("bud", "Budwei\u00dfer", 19.7),
            new Stock("rdi", "Rhodesia Decoder Integrations", 109.9),
            new Stock("upg", "Up&Go", 22),
            new Stock("mmw", "Mariana-Monokai-Webster", 34.8),
            new Stock("krb", "Krasnyi Byk Ltd.", 45.2),
            new Stock("shi", "SuperHaul Instruments", 66.7),
            new Stock("ubm", "UBook Manufacturing & Co.", 59.9),
            new Stock("pgq", "PregresQ LLC", 40.4),
            new Stock("thm", "Tohmatsu Publishing", 22.1),
            new Stock("spqr", "Structurized Preprocessed Query Researchers", 97),
            new Stock("man", "Manchester Disunited & Partners", 88.3)
        };

        roundCount = 1;
        stockMarket = new StockMarket(stocks);            
        portfolio = new Portfolio();
        acquisitionView = new AcquisitionView();
        releasementView = new();
        continueOrExitView = new();
        mainView = new();


        RulesView rules = new RulesView();
        rules.Show();
        while (7 != 8)
            mainView.Show();
    }

}
