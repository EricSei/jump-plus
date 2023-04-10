package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import models.Customer;
import models.Transaction;
import utility.Message;

public class DataBase {
  public DataBase() {
    Message.warn("Databased is loaded");
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

  public static List<Customer> getCustomers() throws Exception {
    String line = "";
    String splitBy = ",";
    List<Customer> customers = new ArrayList<Customer>();
    try {
      // parsing a CSV file into BufferedReader class constructor
      BufferedReader br = new BufferedReader(
          new FileReader("/Users/ericsei/projects/jump-plus/com/data/customers.csv"));
      while ((line = br.readLine()) != null) // returns a Boolean value
      {
        List<String> oneCustomer = Arrays.asList(line.split(splitBy)); // use comma as separator
        Customer customer = new Customer(oneCustomer.get(0), oneCustomer.get(1), oneCustomer.get(2),
            oneCustomer.get(3), oneCustomer.get(4));
        customers.add(customer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("CustmersList Size : " + customers.size());
    return customers;
  }

  // get customers and writer to database
  public static void setCustomers(Customer currentCustomer) {
    try {
      List<Customer> customersList = DataBase.getCustomers();
      // udpate List
      for (int i = 0; i < customersList.size(); i++) {
        if (currentCustomer.getEmail().equals(customersList.get(i).getEmail())) {
          customersList.set(i, currentCustomer);
        }
      }
      // empty file
      FileWriter emptyWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/customers.csv", false);
      emptyWriter.append("");
      emptyWriter.flush();
      emptyWriter.close();

      // Update list to file
      FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/customers.csv", true);

      for (Customer customer : customersList) {
        List<String> rowData = Arrays.asList(customer.getEmail(), customer.getFirstName(),
            customer.getLastName(), customer.getBalance(), customer.getPassword());
        csvWriter.append(String.join(",", rowData));
        csvWriter.append("\n");
      }
      csvWriter.flush();
      csvWriter.close();

    } catch (Exception e) {
      System.out.println("Error out while invokingsetCustomer :" + e);
    }

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
          new FileReader("/Users/ericsei/projects/jump-plus/com/data/transactions.csv"));
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

  public static List<Transaction> loadUserTransactions(Customer customer) throws Exception {
    String line = "";
    String splitBy = ",";
    List<Transaction> customerTransactions = new ArrayList<>();
    try {
      // parsing a CSV file into BufferedReader class constructor
      BufferedReader br = new BufferedReader(
          new FileReader("/Users/ericsei/projects/jump-plus/com/data/transactions.csv"));
      while ((line = br.readLine()) != null) // returns a Boolean value
      {

        String[] eachTransaction = line.split(splitBy); // use comma as separator
        if (eachTransaction[1].equals(customer.getEmail())) {
          customerTransactions.add(new Transaction(Integer.parseInt(eachTransaction[0]), eachTransaction[1],
              eachTransaction[2],
              eachTransaction[3], eachTransaction[3]));
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return customerTransactions;
  }

  public static void writeTransaction(Transaction tranc) throws Exception {
    // String id = Integer.toString(Transaction.id);
    try {
      Message.message("Creating Transaction Id ... ");
      Random rand = new Random();
      int upperbound = 200;
      int int_random = rand.nextInt(upperbound);
      String id = Integer.toString(int_random);

      List<String> rowData = Arrays.asList(id, tranc.sender, tranc.receiver, "TRANSFER",
          tranc.amount);
      FileWriter csvWriter = new FileWriter("/Users/ericsei/projects/jump-plus/com/data/transactions.csv", true);
      csvWriter.append(String.join(",", rowData));
      csvWriter.append("\n");
      csvWriter.flush();
      csvWriter.close();
    } catch (Exception e) {
      Message.error("Error out with " + e);
    }
  }

}