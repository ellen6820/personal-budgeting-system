package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("----------------PERSONAL BUDGETING SYSTEM v 0.2.5----------------");
        User testUser = init_user();
        if (testUser != null) {
            System.out.println("User successfully created.");
            System.out.println("Welcome " + testUser.getEmail() + "!");
            menu_main();
        }
    }

    static User init_user() {
        System.out.println("\nPlease enter some starting credentials.");

        System.out.print("Enter starting balance: ");
        double balance = scanner.nextFloat();

        System.out.print("Enter weekly limit: ");
        double weeklyLimit = scanner.nextFloat();

        System.out.print("Enter email: ");
        String email = scanner.next();

        return new User(balance, weeklyLimit, email);
    }

    static void menu_main() {
        while (true) {
            print_menu_main();
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    menu_purchase();
                    break;
                case 2:
                    menu_see_log();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    static void print_menu_main() {
        printLine();
        System.out.println("!!!\tMAIN MENU\t!!!");
        System.out.println("0\tEXIT");
        System.out.println("1\tMAKE A PURCHASE");
        System.out.println("2\tVIEW TRANSACTION HISTORY");
        printLine();
    }

    static void menu_purchase() {
        System.out.println("!-!-! PURCHASE MENU !-!-!");

        System.out.print("Enter item price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter item type: ");
        String type = scanner.next();

        Transaction purchase = new Transaction();
        purchase.createTransaction(type, (int)price);

        // TODO: check for transaction success
        System.out.println("Item successfully purchased.");
    }

    static void menu_see_log() {
        // TODO: TransactionHistory must be functional somewhere
    }

    // -----------------------------------------------------------
    // ------------------- KEEP FUNCTIONS SAME -------------------
    // -----------------------------------------------------------
    static void exit() {
        System.out.println("Program ended.");
        System.exit(0);
    }

    static void printLine() {
        System.out.println("--------------------------");
    }
}
