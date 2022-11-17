import java.util.Scanner;

public class AcquisitionView {
    public void Show(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Acquire any stocks? [Type \"yes\" to advance] ");
        String answer = scan.nextLine();

        if(answer.toLowerCase().trim() == "yes"){
                try{
                    System.out.print("Enter the indices of stocks you\'d like to acquire: ");
                    String stocks = scan.nextLine();
                    String[] stockArray = stocks.toLowerCase().trim().split(" ");
                    App.portfolio.Acquire(stockArray);
                    App.portfolio.AcquiredAnything = true;
                }
                catch (StockNotFoundException e){
                    AlertMessage.Show("Stocks given by some indices weren\'t found! Try again.");
                    Show();
                }
                catch (StockOwnedAlreadyException e)
                {
                    AlertMessage.Show("Stocks given by some indices are in your portfolio already! Try again.");
                    Show();
                }
                catch (CannotAffordException e)
                {
                    AlertMessage.Show("You cannot afford all these stocks! Try again.");
                    Show();
                }
        }
        else{
            App.portfolio.AcquiredAnything = false;
        }
    }
}
