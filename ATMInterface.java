import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) { 
        if(amount>0){
            balance += amount;
             System.out.println("Deposit successful. New balance" +balance);
        }else{
             System.out.println("Invalid amount for deposit.");
        }
        
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner=new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void operate() {
        
        int choice;
        do {
            displayOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + account.getBalance());
    }

    public void deposit() {
        
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: $" + account.getBalance());
    }

    public void withdraw() {
        
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: $" + account.getBalance());
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.operate();
    }
}
