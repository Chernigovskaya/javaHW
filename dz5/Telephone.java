package dz5;

import java.util.ArrayList;
import java.util.HashMap;

public class Telephone {
    private static HashMap<String, ArrayList<String>> telephoneNumber = new HashMap<>();
    public void add (String name, String number) {
        if (number.length() == 11) {
            if (telephoneNumber.containsKey(name)) {
                telephoneNumber.get(name).add(number);
            } else {
                ArrayList<String> values = new ArrayList<>();
                values.add(number);
                telephoneNumber.put(name, values);
            }
        }
        else {
                System.out.println("У абонента " + name + " введен некорректный номер телефона: " + number);
            }
    }
    public ArrayList<String> find(String name) {
        if(telephoneNumber.containsKey(name)) {
            return telephoneNumber.get(name);
        }
        return new ArrayList<String>();
    }
    public static HashMap<String, ArrayList<String>> getTelephoneNumber() {
        return telephoneNumber;
    }
}
