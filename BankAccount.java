import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Scanner;

class Account {
    static{
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
                "Arial",Font.BOLD,25)));
    }
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }

    public double checkBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null,"Deposit successful. New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null,"Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null,"Withdrawal successful\n"+" New balance: " + balance);
        } else {
            JOptionPane.showMessageDialog(null," Insufficient balance.");
        }
    }
}

class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void displayMenu() {
        JOptionPane.showMessageDialog(null,"ATM Menu:\n" +
                "1. Check Balance\n" +
                "2. Deposit \n" +
                "3. Withdraw \n" +
                " 4. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            String choice_input =JOptionPane.showInputDialog(null,"Enter your choice: ");   ///** */
            choice=Integer.parseInt(choice_input);
            switch (choice) {
                case 1:
                    JOptionPane.showMessageDialog(null,"Current Balance: " + account.checkBalance());
                    break;
                case 2:
                    String deposit=JOptionPane.showInputDialog(null,"Enter deposit amount: ");
                    double depositAmount = Integer.parseInt(deposit);
                    account.deposit(depositAmount);
                    break;
                case 3:
                    String withdrawal=JOptionPane.showInputDialog(null,"Enter withdrawal amount: ");
                    double withdrawalAmount = Integer.parseInt(withdrawal);
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"Thank you For using ATM!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Account userAccount = new Account(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
