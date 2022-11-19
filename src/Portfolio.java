public class Portfolio {
    public static void Show(){
        int count = 0;

        System.out.println();
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nPortfolio");
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\n");

        for (int i = 0; i < App.inv1.length; i++){
            if(App.inv1[i] != 0){
                System.out.println(App.stocks[i]+"	"+App.inv1[i]+" shares at $"+App.inv2[i]+" each.\n");
				count++;
            }
        }
        if (count == 0){
            System.out.println("\nYou do not have any shares yet.\n");
        }
    }
}
