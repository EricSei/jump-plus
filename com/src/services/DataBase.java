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
import java.util.Scanner;

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

    // sign up process
    public static void writeCustomer() throws Exception {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("Jean.author@gmail.com", "jean", "author", "10000"),
                Arrays.asList("David.allen@gmail.com", "david", "allen", "6000"),
                Arrays.asList("Scott.young@gmail.com", " scott", "young", "7000"));

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

    public static void writeTransaction() throws Exception {
        List<List<String>> rows = Arrays.asList(
                Arrays.asList("2", "Jean.author@gmail.com", "David.allen@gmail.com", "transfer", "10000"));

        try {
            FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/transactions.csv", true);
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

}
