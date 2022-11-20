import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);

    public static void rollForRumor(){
        if(App.random.nextInt(6) == 1){
            boolean loop = true;
            int random = App.random.nextInt(6);
            while(loop){
                if(App.rumors[random] == App.oldRumor){
                    random = App.random.nextInt(6);
                } else{
                    if(random == 5){
                        App.barBankrupt = true;
                    }
                    App.thisRumor = App.rumors[random];
                    App.rumor = random;
                    loop = false;
                }
            }
            App.oldRumor = App.thisRumor;
        }
    }

    public static void rollForGfc(){
        if(App.random.nextInt(100) == 1){
            App.gfc = true;
            App.rumor = -2;
            App.thisRumor = "A global financial crisis is predicted! Expect share prices to severely drop!";
        }
    }

    public static void rollForBuyBack(){
        if(App.random.nextInt(100) == 1){
            int random = App.random.nextInt(6);
            double currentPrice = App.exchange[random];
            if(App.inv1[random] != 0){
                System.out.println(App.stocks[random]+" are offering to buy back all of their shares at $"+(currentPrice + (currentPrice * .2))+", do you accept their offer? [y/n]");
                String answer = scanner.next();

                if(answer.equals("y") || answer.equals("Y") || answer.equals("yes")){
                    App.inv1[random] = 0;
                    Money.balance += App.inv2[random] * (currentPrice * .2);
                    Money.balance = Math.round(Money.balance * 100) / 100;
                }
            }
        }
    }

    public static void showNews(){
        if(App.rumor != -1 || App.thisRumor == "The rumor was true!" || App.thisRumor == "The rumor was false!"){
            System.out.println("\nLatest News: "+App.thisRumor);
        }
        if(App.news != ""){
            System.out.println("\n"+App.news);
			App.news = "";
        }
    }

    public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void gameOver(int reason) {
		System.out.println("\n\n\n\n\n\n\n\n\n" +
							"	GAME OVER\n");
		if(reason == 1) { 
			System.out.println("\nYou failed to pay back Logan.\n");
		} else {
			System.out.println("\nFinal score: $"+Money.balance+"\n");
		}
		System.out.println("\n\n");
	}
}
