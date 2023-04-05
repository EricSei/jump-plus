import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import models.Bank;
import services.DataBase;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcom From Bank Of America");

        Bank bankOfAmerica = new Bank();
        DataBase dataBase = new DataBase();

        HashMap<String, ArrayList<String>> employeeAccountHistory = new HashMap<>();

        ArrayList<String> transactions = new ArrayList<String>();
        transactions.add("transaction 1");

        employeeAccountHistory.put("transactions", transactions);

        // dataBase.data.put("John", employeeAccountHistory);

        System.out.print(employeeAccountHistory.get("transactions").get(0));
    }
}
