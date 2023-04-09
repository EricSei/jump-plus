import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.crypto.Data;

import models.Account;
import services.DataBase;

public class DollarsBankApplication {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcom From Bank Of America");

        // Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        // System.out.print("Enter first number- ");
        // int a = sc.nextInt();
        // System.out.print("Enter second number- ");
        // int b = sc.nextInt();
        // System.out.print("Enter third number- ");
        // int c = sc.nextInt();
        // int d = a + b + c;
        // System.out.println("Total= " + d);

        // parsing a CSV file into Scanner class constructor
        // Scanner sc1 = new Scanner(new
        // File("/Users/ericsei/projects/jump-plus/com/data/books.csv"));
        // sc1.useDelimiter(" ,"); // sets the delimiter pattern
        // while (sc1.hasNext()) // returns a boolean value
        // {
        // System.out.print(sc1.next()); // find and returns the next complete token
        // from this scanner
        // }
        // sc1.close(); // closes the scanner

        // DataBase.loadCustomers();
        // DataBase.writeCustomer();
        DataBase.loadCustomers();

        // DataBase.writeTransaction();

        Account bankOfAmerica = new Account();
        DataBase dataBase = new DataBase();

        HashMap<String, ArrayList<String>> employeeAccountHistory = new HashMap<>();

        ArrayList<String> transactions = new ArrayList<String>();
        transactions.add("transaction 0");

        employeeAccountHistory.put("transactions", transactions);

        // dataBase.data.put("John", employeeAccountHistory);

        // System.out.print(employeeAccountHistory.get("transactions").get(0));
    }
}
