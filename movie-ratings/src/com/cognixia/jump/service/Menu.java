package com.cognixia.jump.service;

import com.cognixia.jump.utility.Message;

public class Menu {
    public static void mainDisplay() {
  
        Message.title("- - - - - - - - - - - - - - ");
        Message.title("1 : Log In \n2 : Sign Up \n3 : Quit");
        Message.title("- - - - - - - - - - - - - - ");
    }

    public static void userActionsDisplay() {
        Message.title("- - - - - - - - - - - - - - ");
        Message.title(
                "1 : Rate A Movie \n2 : View All My Ratings \n3 : List All Movies \n4 : Logged out");
        Message.title("- - - - - - - - - - - - - - ");
    }
}
