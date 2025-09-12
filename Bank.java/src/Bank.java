import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    String bankName;
    String branchCode;
    String address;
    List<String> accounts = new ArrayList<>();
    List<String> employees = new ArrayList<>();

    Bank(String bankName, String branchCode, String address) {
        this.bankName = bankName;
        this.branchCode = branchCode;
        this.address = address;
    }

    void findAccount(String name) {
        if (accounts.contains(name))
            System.out.println("Account found: " + name);
        else
            System.out.println("Account not found: " + name);
    }

    void displayAllAccounts() {
        System.out.println("Accounts: " + accounts);
    }

    void displayBankName() {
        System.out.println("Bank Name: " + bankName);
    }

    void displayAddress() {
        System.out.println("Address: " + address);
    }

    void displayEmployees() {
        System.out.println("Employees: " + employees);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Bank Name: ");
        String bName = sc.nextLine();
        System.out.print("Enter Branch Code: ");
        String bCode = sc.nextLine();
        System.out.print("Enter Bank Address: ");
        String addr = sc.nextLine();

        Bank bank = new Bank(bName, bCode, addr);

        System.out.print("How many accounts?: ");
        int accCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < accCount; i++) {
            System.out.print("Enter account holder name: ");
            bank.accounts.add(sc.nextLine());
        }

        System.out.print("How many employees?: ");
        int empCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < empCount; i++) {
            System.out.print("Enter employee name: ");
            bank.employees.add(sc.nextLine());
        }

        bank.displayBankName();
        bank.displayAddress();
        bank.displayAllAccounts();
        bank.displayEmployees();

        System.out.print("Search account name: ");
        String searchName = sc.nextLine();
        bank.findAccount(searchName);

        sc.close();
    }
}
