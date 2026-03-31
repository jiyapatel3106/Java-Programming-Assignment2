// Program 3:
// Implement CRUD operations using Collection API
// (ArrayList, HashMap, TreeMap)

import java.util.*;

public class Program3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        HashMap<Integer, Double> accounts = new HashMap<>();
        while (true) {
            System.out.println("\n--- Simple CRUD Menu ---");
            System.out.println("1. Add Name (ArrayList)");
            System.out.println("2. Update Name (ArrayList)");
            System.out.println("3. Add Account (HashMap)");
            System.out.println("4. View Accounts (HashMap)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    names.add(sc.nextLine());
                    System.out.println("Names: " + names);
                    break;
                case 2:
                    System.out.print("Enter index to update: ");
                    int idx = sc.nextInt();
                    sc.nextLine();
                    if (idx >= 0 && idx < names.size()) {
                        System.out.print("Enter new name: ");
                        names.set(idx, sc.nextLine());
                        System.out.println("Updated Names: " + names);
                    } else {
                        System.out.println("Invalid index!");
                    }
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter balance: ");
                    double bal = sc.nextDouble();
                    accounts.put(id, bal);
                    System.out.println("Account added!");
                    break;
                case 4:
                    System.out.println("Accounts: " + accounts);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}