public class Authorization {
    public static void Login(){
        for(int i = 0; i < 33; i++) System.out.print("=");
        System.out.println("\nLogin");
        for(int i = 0; i < 33; i++) System.out.print("=");

        System.out.print("\n\nUsername: ");
        App.usernameInput = App.scanner.nextLine();
        System.out.print("Password: ");
        App.passwordInput = App.scanner.nextLine();
        
        while((App.usernameInput == App.username) && (App.passwordInput == App.password)){
            System.out.println("Please enter a valid username or password!");
            System.out.print("\nUsername: ");
            App.usernameInput = App.scanner.nextLine();
            System.out.print("Password: ");
            App.passwordInput = App.scanner.nextLine(); 
        }
    }
}