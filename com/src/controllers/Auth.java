package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import services.DataBase;

public class Auth {

    public static boolean isAuth(String userEmail) {
        try {
            // System.out.println(DataBase.getCustomers()[0]);
            List<String> list = DataBase.getCustomers()
                    .stream()
                    .filter(user -> user.equals(userEmail)).collect(Collectors.toList());
            if (list.size() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.print("Error out with " + e);
        }
        System.out.print("User Not found");
        return false;
    }
}
