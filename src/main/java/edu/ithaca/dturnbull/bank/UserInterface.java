package edu.ithaca.dturnbull.bank;

import java.util.Scanner;
import java.util.InputMismatchException;
import javax.naming.InsufficientResourcesException;

public class UserInterface {

    static Scanner scanner = new Scanner(System.in);
    static Parent user;
    static String username;
    static String frog;

    public static void main(String[] args) throws InvalidInputException, InsufficientResourcesException {
        System.out.println("| ------ | PERSONAL BUDGETING SYSTEM v0.9.8 | ------ |");
        Parent testUser = init_user();
        if (testUser != null) {
            System.out.println("\nUser successfully created.");
            System.out.println("Welcome " + username + "!");
            menu_main();
        }
    }

    static Parent init_user() {
        System.out.println("\nPlease enter some starting credentials.");

        double balance = askForDouble("Enter starting balance: ");
        double weeklyLimit = askForDouble("Enter weekly limit: ");
        String email = askForEmail("Enter email: ");
        username = email.substring(0, email.indexOf("@")).toUpperCase();

        user = new Parent(balance, weeklyLimit, email);
        return user;
    }

    static void menu_main() throws InvalidInputException, InsufficientResourcesException {
        while (true) {
            print_menu_main();
            int choice = askForInt("CHOICE: ");
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
                    menu_alter_limit(user);
                    break;
                case 4:
                    print_user_balance(user);
                    break;
                case 5:
                    System.out.println("Navigating to Family Menu");
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

        double price = askForDouble("Enter item price: ");

        System.out.print("Enter item type: ");
        String type = scanner.next();

        int startSize = user.getTransactions().size();
        try {
            user.createTransaction(type, price);
        } catch (Exception InsufficientResourcesException) {
        }

        String output = user.getTransactions().size() == startSize + 1
                ? "Item successfully purchased."
                : "Insufficient funds.";
        System.out.println(output);
    }

    static void menu_see_log() {
        System.out.println(username + "'s purchases:");
        System.out.println(user.seeHistory());
    }

    static void menu_alter_limit(User localUser) throws InvalidInputException {
        System.out.println("The current limit is: " + localUser.getLimit());
        float newLimit = (float) askForDouble("Enter desired weekly limit: ");
        localUser.createLimit(newLimit);
        if (localUser.getLimit() == newLimit) {
            System.out.println("\nSuccessful limit change.");
        } else {
            System.out.println("\nUnsuccessful change to limit.");
        }
    }

    static void print_manage_family() {
        printLine();
        System.out.println("- FAMILY MENU - ");
        System.out.println("0\tEXIT");
        System.out.println("1\tADD CHILD");
        System.out.println("2\tCHANGE CHILD LIMIT");
        System.out.println("3\tVIEW CHILD INFO");
        System.out.println("4\tBACK TO MAIN MENU");
    }

    static void menu_manage_family() throws InvalidInputException {
        boolean in_menu = true;
        int childNum;
        while (in_menu) {
            print_manage_family();
            int choice = askForInt("CHOICE: ");
            printLine();
            switch (choice) {
                case 0:
                    exit();
                    break;
                case 1:
                    init_child();
                    break;
                case 2:
                    childNum = chooseChild();
                    if (childNum >= 0) {
                        menu_alter_limit(user.getChildren().get(childNum));
                    }
                    break;
                case 3:
                    childNum = chooseChild();
                    if (childNum >= 0) {
                        print_user_balance(user.getChildren().get(childNum));
                    }
                    break;
                case 4:
                    System.out.println("Navigating to Main Menu");
                    in_menu = false;
                    break;
                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }

    static void init_child() {
        if (user.getChildren().size() == 0) {
            System.out.println("Welcome to Tiger Parent status.");
        } else {
            System.out.println("You have " + user.getChildren().size() + " kid(s) with accounts.");
        }
        System.out.println("Please enter the new child's credentials.\n");

        double balance = askForDouble("Enter starting balance: ");
        double weeklyLimit = askForDouble("Enter weekly limit: ");
        String email = askForEmail("Enter email: ");
        user.addChild(balance, weeklyLimit, email);
        System.out.println("\nChild account successfully created.");
        System.out.println("You now have " + user.getChildren().size() + " kid(s) with accounts.");
    }

    static int chooseChild() {
        int numChildren = user.getChildren().size();
        if (numChildren == 0) {
            System.out.println("You have no added children to manage.");
            return -1;
        } else if (numChildren == 1) {
            return 0;
        } else {
            System.out.println("- CHOOSE CHILD - ");
            for (int i = 0; i < numChildren; i++) {
                System.out.println((i + 1) + "\t" + user.getChildren().get(i).getEmail());
            }
            int childChoice = askForInt("Choose a child to manage: ");
            return childChoice - 1;
        }
    }

    // -----------------------------------------------------------
    // ------------------- KEEP FUNCTIONS SAME -------------------
    // -----------------------------------------------------------
    static void exit() {
        System.out.println("Program ended.");
        System.exit(0);
    }

    static void printLine() {
        System.out.println("---------------------------");
    }

    static void print_user_balance(User localUser) {
        System.out.println(localUser.getEmail() + " info:");
        System.out.println("Current balance: $" + localUser.getBalance());
        System.out.println("Current limit: $" + localUser.getLimit());
    }

    static int askForInt(String message) {
        System.out.print(message);
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }

    static double askForDouble(String message) {
        System.out.print(message);
        double input;
        while (true) {
            try {
                input = scanner.nextDouble();
                return assertDoublePos(input);
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();
            }
        }
    }

    static String askForEmail(String message) {
        System.out.print(message);
        String email;
        boolean isValidEmail;
        while (true) {
            email = scanner.next();
            String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
            java.util.regex.Matcher m = p.matcher(email);
            isValidEmail = m.matches();
            if (isValidEmail) {
                return email;
            } else {
                System.out.print("Invalid email. Please try again: ");
                scanner.nextLine();
            }
        }
    }

    static double assertDoublePos(double num) {
        while (num < 0) {
            System.out.print("Invalid input. Please enter valid number: ");
            num = scanner.nextDouble(); 
        }
        return num;
    }
        
 }
