import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.xml.crypto.Data;

import controllers.Auth;
import models.Account;
import services.DataBase;

public class DollarsBankApplication {
  public static void main(String[] args) throws Exception {

    System.out.println("Welcom From Bank Of America");

    DataBase bankDatabase = new DataBase();
    // bankDatabase.writeCustomer();

    // DataBase.loadCustomers();

    // DataBase.writeTransaction();

    // DataBase.writeTransaction("eric@gmail.com");

    Auth auth = new Auth();

    if (Auth.isAuth("sui@gmail.com")) {
      System.out.print("User is authenticated.");
    } else {
      System.out.print("User is not found. Create a new account. Bye");
    }

    // ---------------

    // Account bankOfAmerica = new Account();
    // DataBase dataBase = new DataBase();

    // HashMap<String, ArrayList<String>> employeeAccountHistory = new HashMap<>();

    // ArrayList<String> transactions = new ArrayList<String>();
    // transactions.add("transaction 0");

    // employeeAccountHistory.put("transactions", transactions);

    // dataBase.data.put("John", employeeAccountHistory);

    // System.out.print(employeeAccountHistory.get("transactions").get(0));
  }
}
