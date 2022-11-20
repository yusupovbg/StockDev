import java.util.Scanner;

public class Money {
    public static String answer = "";
    public static double balance = 200.0;
    public static double debt = 0.0;
    public static boolean borrowed = false, lastChance = false;
    private static int input;
    private static Scanner scanner = new Scanner(System.in);

    public static void loanShark(){
        System.out.println();
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nLoan Shark");
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println();
        System.out.println("\nHow much would you like to borrow from Logan the loan shark? (intrest rate of 5% per day)\n");
		input = scanner.nextInt();
		System.out.println("Are you sure you wish to borrow $"+input+"? Intrest will be $"+(input * .05)+" per day. [y/n]\n");
		answer	= scanner.next();

        if(answer.equals("y") || answer.equals("Y") || answer.equals("yes")){
            debt = input;
            balance += input;
			balance = Math.round(balance * 100) / 100;
            borrowed = true;
            App.news = "You have been granted the money. Logan will be visiting in 5 days to get his money back.";
            App.daysLeft = 5;
        } else {
			System.out.println("Logan walked.");
		}
    }

    public static double fluctuate(double fluctuation, String trait){
        int chance = App.random.nextInt(3);
        double random = App.random.nextDouble();
        int[] change = {0, 0, 0};

        if(trait.equals("STABLE")) {
			change[0] = 2;
			change[1] = 5;
			change[2] = 1;
		} else {
			change[0] = 3;
			change[1] = 7;
			change[2] = 3;
		}

        switch(chance) {
			case 0: fluctuation	= fluctuation + (random * change[0]) - change[0];
			case 1: fluctuation	= fluctuation + (random * change[1]);
			case 2: fluctuation	= fluctuation - (random * change[2]);
		}

        if(App.gfc == true) {
			fluctuation	= fluctuation - (fluctuation * .8);
		}

        if(fluctuation < 0.0) {
			fluctuation	= 0.0;
		}

        return (Math.round(fluctuation * 100.0) / 100.0);
    }

    public static boolean enoughFunds(int comID, int quantity) {
		if(Money.balance >= (App.exchange[comID-1] * quantity)) {
			return true;
		} else {
			return false;
		}
	}

    public static void buyStock() {
		int amount;
		double currentPrice = 0;
        System.out.println();
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nBuy Stocks");
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\n");
		System.out.println("1. Oibes & Co.\n" + "2. Rhodesia Decoder Integrations.\n" + "3. Up&Go\n" + "4. Mariana-Monokai-Webster.\n" + "5. Krasnyi Byk Ltd.\n" + "6. PregresQ LLC\n" + "7. Back\n");
		input	= scanner.nextInt();
		if(input == 7) {
			App.menu();
		}
		System.out.println("\nHow many?\n");
		amount	= scanner.nextInt();
		
		if(input > 0 && input < 7) {
			if(Money.enoughFunds(input, amount) == true) {
				currentPrice = App.exchange[input-1];
				if(currentPrice == 0.0) {
					System.out.println("\nYou can't buy stocks at $0.00\n");
					Game.sleep(500);
				} else {
					App.inv1[input-1] += amount;
					App.inv2[input-1] = currentPrice;
					Money.balance -= (currentPrice * amount);
					Money.balance = Math.round(Money.balance * 100) / 100;
					System.out.println("\nStocks purchased!\n");
				}
			} else {
				System.out.println("\nYou don't have enough capital to buy these shares.\n");
			}
		}
	}

    public static void sellStock() {
		int amount;
		double oldPrice	= 0.0;
		double currentPrice = 0.0;
        System.out.println();
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nSell Stocks");
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\n");
		System.out.println("1. Oibes & Co.\t("+App.inv1[0]+")\n" + "2. Rhodesia Decoder Integrations\t("+App.inv1[1]+")\n" + "3. Up&Go\t("+App.inv1[2]+")\n" + "4. Mariana-Monokai-Webster.\t("+App.inv1[3]+")\n" + "5. Krasnyi Byk Ltd.\t("+App.inv1[4]+")\n" + "6. PregresQ LLC\t("+App.inv1[5]+")\n" + "7. Back\n");
		input	= scanner.nextInt();
		if(input == 7) {
			App.menu();
		}
		System.out.println("\nHow many?\n");
		amount	= scanner.nextInt();
		
		if(amount > App.inv1[input-1]) {
			System.out.println("\nYou only have "+ App.inv1[input-1]+" shares in that company.\n");
			Game.sleep(500);
			sellStock();
		} else {
			oldPrice = App.inv2[input-1];
			currentPrice = App.exchange[input-1];
			App.inv1[input-1] -= amount;
			Money.balance += (amount * currentPrice);
			Money.balance = Math.round(Money.balance * 100) / 100;
			
			System.out.println("\nShares sold! Profit made: $"+((currentPrice - oldPrice)*amount+"\n"));
		}
	}
}
