package com.cognixia.jump.service;

import com.cognixia.jump.service.Message;

public class Menu {
    public static void mainDisplay() {
  
        Message.title(" - - - - - - - - - - - -");
        Message.title("|	1 : Log In	|"
        		+ "\n|	2 : Sign Up	|"
        		+ "\n|	3 : Quit	|");
        Message.title(" - - - - - - - - - - - -");
    }

    public static void classActionsDisplay() {
        Message.title(" - - - - - - - - - - - - - - - - - - - - - - - - ");
        Message.title(
                "|	1 : Create A Class			|"
                + "\n|	2 : View A Class			|"
                + "\n|	3 : List All Your Classes		|"
                + "\n|	4 : Find Average and Median for a class	|"
                + "\n|	5 : Sort Classes By Names		|"
                + "\n|	6 : Sort Classes By Grade		|"
                + "\n|	7 : Update A Grade			|"
                + "\n|	8 : Logged out				|");
        Message.title(" - - - - - - - - - - - - - - - - - - - - - - - - ");
    }
}
