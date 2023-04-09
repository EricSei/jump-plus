package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import models.Transaction;

public class DataBase {
    public Map<String, HashMap<String, ArrayList>> data;

    /**
     * John : {
     * balance: 5000,
     * transactions: [ 1, 2 , 4, 5 ]
     * }
     */

    public DataBase() {
        this.data = new HashMap<String, HashMap<String, ArrayList>>();
    }

    // display customers
    public static void loadCustomers() throws Exception {
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/ericsei/projects/jump-plus/com/data/customers.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] employee = line.split(splitBy); // use comma as separator
                System.out.println(
                        "Customer [ Email =" + employee[0] + ", First Name =" + employee[1] + ", Last Name="
                                + employee[2]
                                + ", Balance=" + employee[3] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" -- -- -- -- -- ");
    }

    public static List<String> getCustomers() throws Exception {
        String line = "";
        String splitBy = ",";
        List<String> customers = new ArrayList<String>();
        try {
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/ericsei/projects/jump-plus/com/data/customers.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {

                List<String> oneCustomer = Arrays.asList(line.split(splitBy)); // use comma as separator
                customers.add(oneCustomer.get(0));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // sign up process
    public void writeCustomer(String email, String firstName, String lastName, String balance) throws Exception {

        List<List<String>> rows = Arrays.asList(
                Arrays.asList(email, firstName, lastName, balance));
        try {
            FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/customers.csv", true);
            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.out.println("Error out with " + e);
        }

    }

    public void writeCustomer() throws Exception {
        System.out.println("Creating New User");
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Your Email.");
            String email = sc.nextLine();
            System.out.println("Enter Your First Name.");

            String firstName = sc.nextLine();
            System.out.println("Enter Your Last Name.");
            String lastName = sc.nextLine();
            System.out.println("Enter Enter Password.");
            String passwrod = sc.nextLine();
            String balance = "5000";
            List<String> rowData = Arrays.asList(email, firstName, lastName, balance, passwrod);
            FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/customers.csv", true);
            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
            sc.close();
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.out.println("Error out with " + e);
        }

    }

    public static void loadTransactions() throws Exception {
        String line = "";
        String splitBy = ",";
        try {
            // parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/ericsei/projects/jump-plus/com/data/customers.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] employee = line.split(splitBy); // use comma as separator
                System.out.println(
                        "Customer [ Email =" + employee[0] + ", First Name =" + employee[1] + ", Last Name="
                                + employee[2]
                                + ", Balance=" + employee[3] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(" -- -- -- -- -- ");
    }

    public static void writeTransaction(String crrentUserEmail) throws Exception {
        // String id = Integer.toString(Transaction.id);
        try {
            System.out.print("Creating Transaction Id ... ");
            Random rand = new Random();
            int upperbound = 200;
            int int_random = rand.nextInt(upperbound);
            String id = Integer.toString(int_random);

            Scanner sc = new Scanner(System.in);
            String sender = crrentUserEmail;
            System.out.print("Write Receiver Email Address.");
            String receiver = sc.nextLine();
            System.out.print("Enter Transferring amount $$.");
            String amount = sc.nextLine();
            List<String> rowData = Arrays.asList(id, sender, receiver, "transfer",
                    amount);
            FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/transactions.csv", true);

            csvWriter.append(String.join(",", rowData));
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (Exception e) {
            System.out.println("Error out with " + e);
        }
    }

}

// List<List<String>> rows = Arrays.asList(
// Arrays.asList(email, firstName, lastName, balance, passwrod));
// FileWriter csvWriter = new
// FileWriter("/Users/ericsei/projects/jump-plus/com/data/customers.csv", true);
// for (List<String> rowData : rows) {
// csvWriter.append(String.join(",", rowData));
// csvWriter.append("\n");
// }
// sc.close();
// csvWriter.flush();
// csvWriter.close();