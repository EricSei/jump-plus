import java.util.Scanner;
import controllers.Auth;
import services.Menu;
import utility.Message;

public class DollarsBankApplication {
  public static void main(String[] args) throws Exception {
    Message.message("--- Welcome From Bank. ---");
    boolean isQuit = false;
    do {
      Menu.mainDisplay();
      Scanner sc = new Scanner(System.in);
      Message.message("Select An Option by choosing a number: ");
      String expression = sc.nextLine();
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
          Message.message("Quit. Thanks for using the Bank.");
          break;
        default:
          Message.error("This is invalid option. Pick 1, 2, 3.");
      }
    } while (!isQuit);
  }
}
