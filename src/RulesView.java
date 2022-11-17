import java.util.Scanner;
public class RulesView {
    public void Show() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        for(int i=0; i < 33; i++) System.out.print("*");

        String welcome = "Welcome to StockDev - the non-commercial stock market simulator!\n";
        System.out.println(welcome);

        String theGoal = ">>> Consider you became a trader. You have $200 on your account balance at the start of the game. You plan to increase that as much as possible by trading the stocks of companies listed on the stock market.\n";
        System.out.println(theGoal);

        String everyRound = ">>> Every round is initiated by displaying a listing of all stocks available on the market. Each one has got its full name, shorter index and price, depicted with how it has changed compared to previous round. Right below that you will see the list of stocks currently included in your portfolio and your current account balance.\n";
        System.out.println(everyRound);

        String acquire = ">>> The first question you will encounter is whether you want to acquire any stocks during a particular round. By the way, this will not be shown if you have less money on your account than what is required to buy the least expensive stock. It looks like this:\n\nAcquire any stocks? [Type \"yes\" to advance] \n\nIf the phrase you typed is exactly \"yes\", then the acquisition either proceeds or will be interrupted by quite a self-describing warning; otherwise, the next question in-order is to be displayed.\n";
        System.out.println(acquire);

        String release = ">>> Another question is whether you would like to release any stocks during a particular round. That\'s how it looks:\n\nRelease any stocks? [Type \"yes\" to advance] \n\nIf the phrase you typed is exactly \"yes\", then the releasement either proceeds or will be interrupted by an undoubtedly understandable warning; otherwise, the next question in-order is to be displayed.\n";
        System.out.println(release);

        String continueExit = ">>> Lastly, every round has this question enclosed:\n\nAdvance to next round? [Type \"no\" to KILL game] \n\nIf the phrase you typed is exactly \"no\", then the game is over and the app will self-exit; otherwise, the game is to be continued with the next round forthcoming as usually.\n";
        System.out.println(continueExit);

        System.out.println("[Press ENTER to continue...]");
        if (scan.hasNextLine())
        {
            System.out.println();
            Thread.sleep(800);
        }
    }
}
