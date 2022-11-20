import java.util.Random;
import java.util.Scanner;

public class App {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);
    public static int input, round, daysLeft = 0, count = 0, gfcCount = 0;
    public static String ver = "1.0.0";
    public static int[] inv1 = {0, 0, 0, 0, 0, 0};
    public static double[] inv2 = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    public static boolean gfc = false;
    public static int rumor = -1;
    public static double[] priorPrice = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    public static double[] difference = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
    public static String thisRumor, oldRumor, rumorResult = "", news = "";
    public static String[] rumors = {"Oibes & Co. have hired a new CEO, share prices are expected to drop.", "Charity commends Rhodesia Decoder Integrations for their most recent work, share prices set to rise.", "Up&Go has been rumored to be carelessly dumping toxic waste into a nearby river, prices set to drop.", "Mariana-Monokai-Webster released smear campaign against Up&Go, Up&Go prices expected to fall.", "Experts predict Up&Go share prices are going to rise.", "There are rumors that Mariana-Monokai-Webster is bankrupt and will pull out of the stock exchange. Share prices are expected to drop severely."};
    public static String[] stocks = {"Oibes & Co.", "Rhodesia Decoder Integrations", "Up&Go", "Mariana-Monokai-Webster", "Krasnyi Byk Ltd.", "PregresQ LLC"};
	public static double[] exchange	= {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
	public static String[] traits	= {"STABLE", "UNSTABLE", "STABLE", "UNSTABLE", "STABLE", "UNSTABLE"};
	public static boolean barBankrupt = false;
    public static void main(String[] args) throws Exception {
        run();
		Rules.Show();
    }

    public static void menu(){
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nStockDev v"+ver);
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.print("\n\nYour Balance: $"+Money.balance+" (");
		if(Money.balanceDifference > 0)
			System.out.println("+"+Money.balanceDifference+")");
		else
			System.out.println(Money.balanceDifference+")");

        if(Money.borrowed == true) System.out.println("You are $"+Money.debt+" in debt");
        Game.showNews();
        System.out.println("\n1. View Stocks\n" + "2. Buy Stocks\n" + "3. Sell Stocks\n" + "4. My Portfolio\n" + "5. Next Round\n" + "6. Loan Shark\n" + "7. Exit");

        System.out.println();

        if(scanner.hasNextInt() == true) {
			input = scanner.nextInt();
		} else {
			scanner.next();
		}

        switch(input) {
			case 1: stockPrices(); menu();
			case 2: Money.buyStock(); menu();
			case 3: Money.sellStock(); menu();
			case 4: Portfolio.Show(); menu();
			case 5: nextRound(); stockPrices(); menu();
			case 6: Money.loanShark(); menu();
			case 7: System.exit(0);
			case 8: next100(); menu();
			case 9: while(count <= 100) { Game.rollForRumor(); count++; } count = 0; menu();
			case 100: Money.balance += 500; menu();
			default: System.out.println("\nPlease enter a valid choice.\n"); Game.sleep(500); menu();
		}
    }

    private static void run(){
        for(int i = 0; i < 6; i++){
            exchange[i] = Math.round(random.nextDouble(200) * 100.0) / 100.0;
            if(i == 5 || i == 6)
                exchange[i] = Math.round((random.nextDouble(300) + 20) * 100.0) / 100.0;
        }
        round = 1;
    }

    private static void stockPrices(){
        System.out.println();
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nStocks");
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\n");
        for(int i = 0; i < stocks.length; i++){
            System.out.print(stocks[i]+" - " + "$" + exchange[i]+" ");
            if(difference[i]>0){
                System.out.println("(+"+difference[i]+")");
            } else {
                System.out.println("("+difference[i]+")");
            }
        }
        System.out.println();
    }

    public static void nextRound() {
		for(int i=0; i < exchange.length; i++) {
            priorPrice[i] = exchange[i];
			exchange[i]	= Money.fluctuate(exchange[i], traits[i]);
            difference[i] = exchange[i] - priorPrice[i];
            difference[i] = Math.round(difference[i] * 100.0) / 100.0;
		}
		
		if(rumor != -1) {
			if(random.nextInt(3) != 1) {
				if(gfc == false) {
					switch(rumor) {
						case 0: exchange[0]	= exchange[0] - (exchange[0] * .3); exchange[0]	= Math.round(exchange[0] * 100.0) / 100.0;
						case 1: exchange[1]	= exchange[1] + (exchange[1] * .2); exchange[1]	= Math.round(exchange[1] * 100.0) / 100.0;
						case 2: exchange[2]	= exchange[2] - (exchange[2] * .4); exchange[2]	= Math.round(exchange[2] * 100.0) / 100.0;
						case 3: exchange[2]	= exchange[2] - (exchange[2] * .6); exchange[2]	= Math.round(exchange[2] * 100.0) / 100.0;
					}
					thisRumor = "The rumor was true!";
				}
				rumor = -1;
			} else {
				thisRumor = "The rumor was false!";
				rumor = -1;
			}
		} else {
			if(thisRumor == "") {
				Game.rollForGfc();
				if(gfc == false) {
					Game.rollForRumor();
					Game.rollForBuyBack();
				} else {
					gfcCount = 3;
				}
			} else {
				rumor = -1;
				thisRumor = "";
				rumorResult	= "";
			}
		}
		
		if(daysLeft != 0) {
			daysLeft--;
			Money.debt	= Money.debt + (Money.debt * .05);
		}
		
		if(daysLeft == 1) {
			news = "Logan will be stopping by tomorrow, make sure you have his money!";
		}
		if(Money.borrowed == true && daysLeft == 0) {
			if(Money.balance < Money.debt) {
				news = "You don't have enough money to pay back Logan. You have one more day to pay him back.";
				Money.lastChance = true;
			} else {
				Money.lastChance = false;
				Money.borrowed = false;
				Money.oldBalance = Money.balance;
				Money.balance -= Money.debt;
				Money.balance = Math.round(Money.balance * 100.0) / 100.0;
				Money.balanceDifference = Math.round((Money.balance - Money.oldBalance) * 100.0) / 100.0;
			}
			if(Money.lastChance == true) {
				if(Money.balance < Money.debt) {
					Game.gameOver(1);
				}
			}
		}
		
		if(barBankrupt == true) {
			exchange[3]	= 0.0;
		}
		
		if(gfc == true) {
			gfcCount--;
		}
		
		if(gfc == true && gfcCount == 0) {
			gfc	= false;
		}
	}
	
	public static void next100() {
		int run	= 0;
		for(int i = 0; i < exchange.length; i++) {
			System.out.println("\n");
			while(run <= 100) {
				exchange[i]	= Money.fluctuate(exchange[i], traits[i]);
				System.out.println(exchange[i]);
				run++;
			} run = 0;
		}
	}
}
