package models;

// Each user will be able to:
// ○ Deposit money
// ○ Withdraw money
// ○ Transfer Funds
// ○ View 5 of the most recent transactions in their history
// ○ Display customer information

public class Customer {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String balance;

    public Customer(String email, String firstName, String lastName, String balance, String password) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.balance = balance;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String toString() {
        return "email : " + this.email + " , first name : " + this.firstName + " , last name : " + this.lastName
                + " , balance : " + this.balance + " , password : " + this.password;
    }
}
