package models;

public class Transaction {
    public int id = 0;
    public String sender;
    public String receiver;
    public String action; // "TRANSFER"
    public String amount;

    public Transaction(int id, String sender, String receiver, String action, String amount) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.action = action;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "[ id: " + this.id + ", sender: " + this.sender + ", receiver: " + this.receiver + ", action: "
                + this.action + ", amount: " + this.amount + "]";
    }
}
