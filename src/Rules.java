import java.io.IOException;

public class Rules {
    public static void Show() throws IOException{
        for(int i = 0; i < 33; i++) System.out.print("=");

        System.out.println("\nWelcome to StockDev - the non-commercial stock market simulator!\n");

        String theGoal = ">>> Consider you became a trader. You have $200 on your account balance" +
        " at the start of the game. You plan to increase that" + " as much as possible by" +
        " trading the stocks of companies listed on the stock market.\n";
        
        System.out.println(theGoal);

        String everyRound = ">>> Every round is initiated by displaying a listing of all stocks " +
                "available on the market. Each one has got its full name and price, " +
                "depicted with how it has changed compared to previous round. Right below that " +
                "you will see the list of stocks currently included in your portfolio and your " +
                "current account balance.\n";

        System.out.println(everyRound);

        System.out.print("[Press ENTER to continue...]");

        if(App.scanner.hasNextLine()){
            System.out.println("\n");
            Game.sleep(800);
        }
    }
}