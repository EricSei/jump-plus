package models;

import java.util.Scanner;

import services.DataBase;

// Each user will be able to:
// ○ Deposit money
// ○ Withdraw money
// ○ Transfer Funds
// ○ View 5 of the most recent transactions in their history
// ○ Display customer information
public class Account {
    private Customer currentUser;

    public enum Action {
        DEPOSIT, WITH_DRAW, TANSFER, VIEW, DISPLAY
    }

    public Account(Customer currentUser) {
        System.out.println("Currnet User Account Loaded : ");
        System.out.println("Currnet User Account Loaded : " + currentUser.getEmail());
        this.currentUser = currentUser;
    }

    public Customer getCurrentUser() {
        return this.currentUser;
    }

    public boolean deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Depositing Amount: ");
        String amount = sc.nextLine();
        int totolBalance = Integer.parseInt(amount) + Integer.parseInt(this.currentUser.getBalance());
        this.currentUser.setBalance(Integer.toString(totolBalance));
        DataBase.setCustomers(currentUser);
        return true;
    }

    public boolean withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Withdraw Amount: ");
        String capturedAmount = sc.nextLine();
        int currentBalance = Integer.parseInt(this.currentUser.getBalance());
        int amount = Integer.parseInt(capturedAmount);
        if (amount < 0 || amount > currentBalance) {
            System.out.print("Invalid Input or Insufficient Balance.");
            return false;
        }
        int totolBalance = currentBalance - amount;
        this.currentUser.setBalance(Integer.toString(totolBalance));
        DataBase.setCustomers(currentUser);
        System.out.println(amount + " $ is successfully withdrawn.");
        return true;
    }

    public boolean transfer() {
        String receiverEmail = "";
        // grab receiver

        // deposit into receiver

        // update transaction

        System.out.print("Successfully Tranferred.");
        return true;
    }

}
