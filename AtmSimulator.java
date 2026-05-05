package ErenSoyekOOP;

import java.util.Scanner;


class Account {
 private String accountNumber;
 private String pin;
 private double balance;

 public Account(String accountNumber, String pin, double initialBalance) {
     this.accountNumber = accountNumber;
     this.pin = pin;
     this.balance = initialBalance;
 }

 public boolean authenticate(String inputPin) {
     return this.pin.equals(inputPin);
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Successfully deposited: $" + amount);
     } else {
         System.out.println("Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && balance >= amount) {
         balance -= amount;
         System.out.println("Successfully withdrew: $" + amount);
     } else {
         System.out.println("Insufficient funds or invalid amount.");
     }
 }
}

//Ana Sınıf
public class AtmSimulator {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     // Örnek bir hesap oluşturuyoruz (Şifre: 1905, Bakiye: 1000)
     Account myAccount = new Account("123456789", "1905", 1000.0);

     System.out.println("Welcome to the Global Bank ATM");
     System.out.print("Please enter your PIN: ");
     String inputPin = scanner.nextLine();

     if (myAccount.authenticate(inputPin)) {
         int choice = 0;
         while (choice != 4) {
             System.out.println("\n--- ATM Main Menu ---");
             System.out.println("1. Check Balance");
             System.out.println("2. Deposit Funds");
             System.out.println("3. Withdraw Funds");
             System.out.println("4. Exit");
             System.out.print("Choose an option: ");
             choice = scanner.nextInt();

             switch (choice) {
                 case 1:
                     System.out.println("Current Balance: $" + myAccount.getBalance());
                     break;
                 case 2:
                     System.out.print("Enter amount to deposit: ");
                     double dep = scanner.nextDouble();
                     myAccount.deposit(dep);
                     break;
                 case 3:
                     System.out.print("Enter amount to withdraw: ");
                     double with = scanner.nextDouble();
                     myAccount.withdraw(with);
                     break;
                 case 4:
                     System.out.println("Thank you for using Global Bank ATM. Goodbye!");
                     break;
                 default:
                     System.out.println("Invalid option. Please try again.");
             }
         }
     } else {
         System.out.println("Authentication failed. Incorrect PIN.");
     }
     scanner.close();
 }
}