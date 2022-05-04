package edu.ithaca.dturnbull.bank;

import java.util.Scanner;

import javax.naming.InsufficientResourcesException;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);
    static User user;

    public static void main(String[] args) throws InvalidInputException, InsufficientResourcesException {
        System.out.println("| ------ | PERSONAL BUDGETING SYSTEM v0.2.5 | ------ |");
        User testUser = init_user();
        if (testUser != null) {
            System.out.println("\nUser successfully created.");
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

        user = new User(balance, weeklyLimit, email);

        return user;
    }

    static void menu_main() throws InvalidInputException, InsufficientResourcesException {
        while (true) {
            print_menu_main();
            System.out.print("CHOICE: ");
            int choice = scanner.nextInt();
            printLine();
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
                case 3:
                    menu_alter_limit();
                    break;
                case 4:
                    System.out.println("Your current balance is: " + user.getBalance());
                    break;
                case 5:
                    menu_manage_family();
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }

    static void print_menu_main() {
        printLine();
        System.out.println("- MAIN MENU - ");
        System.out.println("0\tEXIT");
        System.out.println("1\tMAKE A PURCHASE");
        System.out.println("2\tVIEW TRANSACTION HISTORY");
        System.out.println("3\tCHANGE WEEKLY LIMIT");
        System.out.println("4\tVIEW BALANCE & LIMIT");
        System.out.println("5\tOPEN FAMILY MANAGER");
    }

    static void menu_purchase() throws InsufficientResourcesException {
        System.out.println("- PURCHASE MENU - ");

        System.out.print("Enter item price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter item type: ");
        String type = scanner.next();

        int startSize = user.getTransactionHistory().size();
        try {
            user.createTransaction(type, (int)price);
        } catch (Exception InsufficientResourcesException) {}

        String output = user.getTransactionHistory().size() == startSize + 1 
        ? "Item successfully purchased." : "Insufficient funds.";
        System.out.println(output);
    }

    static void menu_see_log() {
        System.out.println(user.getEmail() + "'s purchases:");
        System.out.println(user.seeHistory());
    }

    static void menu_alter_limit() throws InvalidInputException {
        System.out.println("Your current limit is: " + user.getLimit());
        System.out.print("Enter desired weekly limit: ");
        float newLimit = scanner.nextFloat();
        user.createLimit(newLimit);
        if (user.getLimit()==newLimit) {
            System.out.println("Successful limit change.");
        } else {
            System.out.print("Unsuccessful change to limit.");
        }
    }

    static void menu_manage_family() {

    }

    static void print_manage_family() {
        System.out.println("- MANAGE FAMILY - ");
        System.out.println("0\tEXIT");
        System.out.println("1\tADD CHILD");
        System.out.println("2\tCHANGE CHILD LIMIT"); 
        System.out.println("3\tVIEW CHILD"); 
        System.out.println("4\tBACK TO MAIN MENU"); 
    }

    // -----------------------------------------------------------
    // ------------------- KEEP FUNCTIONS SAME -------------------
    // -----------------------------------------------------------
    static void exit() {
        System.out.println("Program ended.");
        System.exit(0);
    }

    static void printLine() {
        System.out.println("-------------------------");
    }
}
