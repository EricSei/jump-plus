package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {
    public Map<String, HashMap<String, ArrayList>> data;

    /**
     * John : {
     * balance: 23,
     * transactions: [ 1,2 , 4, 5 ]
     * }
     */

    public DataBase() {
        this.data = new HashMap<String, HashMap<String, ArrayList>>();
    }
}
