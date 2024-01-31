
import java.util.Scanner;

public class PasswordValidator {

    public static void main(String[] args) {
        String username = "Admin";
        String pwd = "Admin@1234";

        String tmp_username = "";
        String tmp_pwd = "";
        int retries = 0;
        Scanner scanner = new Scanner(System.in);

        while (retries < 3) {
            // On screen instructions and guide
            System.out.println("*** Password Validator ****");
            System.out.println("Enter your credentials below, you only have " + (3 - retries) + " attempts");

            // Enter username
            System.out.println("Username: ");
            tmp_username = scanner.nextLine();

            // Enter password with masking
            char[] passwordChars = System.console().readPassword("Password: ");

            // Display asterisks for each character in the password
            System.out.print("Entered password: ");
            for (int i = 0; i < passwordChars.length; i++) {
                System.out.print("*");
            }
            
            System.out.println();  // Move to the next line after displaying asterisks

            // Validation below
            tmp_pwd = new String(passwordChars);
            if (!tmp_username.equals(username) || !tmp_pwd.equals(pwd)) {
                retries++;
                if (retries < 3) {
                    System.out.println("\nWrong credentials! You have " + (3 - retries) + " attempts left\n");
                } else {
                    System.out.println("\nWrong credentials! No more attempts left. Exiting...\n");
                }
            } else {
                System.out.println("\nValid Password");
                System.out.println("Logging in...");
                break;
            }
        }
        scanner.close();
    }
}
