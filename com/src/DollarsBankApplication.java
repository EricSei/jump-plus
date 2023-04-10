import java.util.Scanner;
import controllers.Auth;
import services.DataBase;
import services.Menu;

public class DollarsBankApplication {
  public static void main(String[] args) throws Exception {

    System.out.println("Welcom From Bank.");

    DataBase bankDatabase = new DataBase();
    // bankDatabase.writeCustomer();

    // DataBase.loadCustomers();

    // DataBase.writeTransaction();

    // DataBase.writeTransaction("eric@gmail.com");

    boolean isQuit = false;
    do {
      Menu.mainDisplay();
      Scanner sc = new Scanner(System.in);
      System.out.print("Select An Option by choosing a number: ");
      String expression = sc.nextLine(); // 1: login, 2: Sign Up, 3: Menu, 4: Quit
      switch (expression) {
        case "1":
          Auth.authController();
          break;
        case "2":
          Auth.signUp();
          break;
        case "3":
          sc.close();
          isQuit = true;
          System.out.print("Quit. Thanks for using the Bank.");
          break;
        default:
          System.out.println("This is invalid option. Quit.");
      }
    } while (!isQuit);
  }
}
