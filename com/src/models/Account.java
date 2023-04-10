package models;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import services.DataBase;
import utility.Message;

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
        Scanner sc = new Scanner(System.in);
        Message.message("Enter Receiver Email:");
        String receiverEmail = sc.nextLine();

        Message.message("Enter Transferring Amount:");
        String amountStr = sc.nextLine();
        int amount = Integer.parseInt(amountStr);

        String senderEmail = this.currentUser.getEmail();
        // udpate sender
        int totolBalance = Integer.parseInt(this.currentUser.getBalance()) - amount;
        this.currentUser.setBalance(Integer.toString(totolBalance));
        DataBase.setCustomers(currentUser);
        try {
            List<Customer> receiverList = DataBase.getCustomers().stream()
                    .filter(user -> user.getEmail().equals(receiverEmail))
                    .collect(Collectors.toList());

            // update receiver

            // && user.getPassword().equals(password)
            if (receiverList.size() > 0) {
                Message.message("Found Receiver");
                Customer receiver = receiverList.get(0);
                // deposit into receiver
                receiver.setBalance(Integer.toString(Integer.parseInt(receiver.getBalance()) + amount));
                DataBase.setCustomers(receiver);
            } else {
                Message.error("User Not found");
                currentUser = null;
                return false;
            }
        } catch (Exception e) {
            Message.error("error out with" + e);
        }
        // update transaction
        try {
            Transaction tranc = new Transaction(1, senderEmail, receiverEmail, "TANSFER",
                    Integer.toString(amount));
            DataBase.writeTransaction(tranc);
        } catch (Exception e) {
            Message.error("error out with" + e);
        }
        Message.message("Successfully Tranferred.");
        return true;
    }

    public void loadTransactionsHistory() {
        Message.message(" Loading Transaction History.");
        try {
            List<Transaction> list = DataBase.loadUserTransactions(this.getCurrentUser());
            for (Transaction ts : list) {
                Message.message(ts.toString());
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
