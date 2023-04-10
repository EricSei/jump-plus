package services;

import utility.Message;

public class Menu {
    public static void mainDisplay() {
        Message.title("- - - - - - - - - - - - - - ");
        Message.title("1 : Log In \n2 : Sign Up \n3 : Quit");
        Message.title("- - - - - - - - - - - - - - ");
    }

    public static void userActionsDisplay() {
        Message.title("- - - - - - - - - - - - - - ");
        Message.title("1 : Deposit \n2: Withdraw \n3 : Transfer \n4 : View Balance  \n5 : Logged out");
        Message.title("- - - - - - - - - - - - - - ");
    }
}
