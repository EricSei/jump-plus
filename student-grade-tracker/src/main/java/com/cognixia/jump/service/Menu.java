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
        Message.title(" + - - - - - - - - - - - - - - - - - - - - - - + ");
        Message.title(
                "|	1 : Create A Class			|"
                + "\n|	2 : View A Class			|"
                + "\n|	0 : Logged out				|");
        Message.title(" + - - - - - - - - - - - - - - - - - - - - - - + ");
    }
    
    public static void studentsByClassActions() {
    	Message.title(" + - - - - - - - - - - - - - - - - - - - - - - + ");
        Message.title("|	1 : Sort Classes By Names		|"
                + "\n|	2 : Sort Classes By Grade		|"
                + "\n|	3 : Update A Grade			|"
                + "\n|	4 : Remove A Student from the class			|"
                + "\n|	5 : Add a Student to the class			|"
                + "\n|	6 : Go Back to View Classes			|"
                + "\n|	0 : Logged out				|");
        Message.title(" + - - - - - - - - - - - - - - - - - - - - - - + ");
    }
}
