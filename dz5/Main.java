package dz5;

import seminar5.Passport;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
//     1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    public static void main(String[] args) {
        personTelephoneNumber();
}
    public static void personTelephoneNumber() {
        Telephone people = new Telephone();
        people.add("Васильев", "89130645413");
        people.add("Петрова", "89564235648");
        people.add("Иванов", "89461537546");
        people.add("Петрова", "86491253786");
        people.add("Иванов", "86123469571");
        people.add("Иванов", "861234695711");

        System.out.println(people.find("Петрова"));
        System.out.println(people.getTelephoneNumber());
    }

}
