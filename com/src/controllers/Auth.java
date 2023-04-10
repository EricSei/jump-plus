package controllers;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import models.Account;
import models.Customer;
import services.DataBase;
import services.Menu;

public class Auth {

  public static boolean isLoggedIn = false;
  public static Customer currentUser = null;

  public static void authController() {

    Customer currentUser = null;
    try {
      List<Customer> list = DataBase.getCustomers();

      // .stream()
      // .filter(user -> user.getEmail().equals(userEmail) &&
      // user.getPassword().equals(password))
      // .collect(Collectors.toList());

      Scanner sc = new Scanner(System.in);
      System.out.print("Enter Your Email: ");
      String userEmail = sc.nextLine();
      System.out.print("Enter Your Password: ");
      String password = sc.nextLine();

      currentUser = Auth.authUser(userEmail, password, list);
      currentUser.display();

      if (currentUser.getEmail() == null) {
        System.out.println(" Please Create New Account.");
        return;
      }
      isLoggedIn = true;
    } catch (Exception e) {
      System.out.print("Error out with " + e);
    }

    do {
      Menu.userActionsDisplay();
      Account account = new Account(currentUser);

      Scanner sc2 = new Scanner(System.in);
      System.out.print("Select An Option by choosing a number:");

      String expression = sc2.nextLine();
      switch (expression) {
        case "1":
          System.out.println("Depositing ...");
          account.deposit();
          break;
        case "2":
          System.out.println("WithDrawing ...");
          account.withdraw();
          break;
        case "3":
          System.out.print("Transferrring ...");
          account.transfer();
          break;
        case "4":
          sc2.close();
          isLoggedIn = false;
          System.out.println(" You have been logged Out. Thanks for using the Bank.");
          break;
        default:
          System.out.println("This is invalid option. Quit.");
      }
    } while (Auth.isLoggedIn);
  }

  public static Customer authUser(String userEmail, String password, List<Customer> list) {
    List<Customer> authUserList = list.stream()
        .filter(user -> user.getEmail().equals(userEmail))
        .collect(Collectors.toList());
    // && user.getPassword().equals(password)
    if (authUserList.size() > 0) {
      System.out.println("Found User");
      return authUserList.get(0);
    } else {
      System.out.print("User Not found");
      currentUser = null;
      return null;
    }

  }

  public static void signUp() throws Exception {
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
      String password = sc.nextLine();
      String balance = "5000";
      List<String> rowData = Arrays.asList(email, firstName, lastName, balance, password);
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
}
