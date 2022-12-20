package seminar1;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 3, 3, 2, 2, 3};
        int val = arr.length;
        pushNumNoEnd(arr, val);
        System.out.println("После перемещения 3 в конец: ");
        for (int i = 0; i < val; i++) {
            System.out.print(arr[i] + " ");
        }
//        stringRevers();
//        stringRevers2();


//        longestCommonPrefix();

//        int[] arr = {3,2,2,3};
//        System.out.println(Arrays.toString(arrChangeNoEnd(arr)));


//        int[] arr = {1,1,0,1,1,1};
//        System.out.println(countNumberOne(arr));

    }
    /** Написать программу, которая запросит пользователя ввести <Имя> в консоли.
     Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”
     */
    public static void printName (String[] args){
        System.out.print("Введите имя: ");
        Scanner enterName = new Scanner(System.in);
        String name = enterName.nextLine();
        System.out.println("Привет, " + name + "!");
    }
    /* В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
    "Доброе утро, <Имя>!", если время от 05:00 до 11:59
    "Добрый день, <Имя>!", если время от 12:00 до 17:59;
    "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
    "Доброй ночи, <Имя>!", если время от 23:00 до 4:59

    public static void task2 (){
        System.out.print("Введите имя: ");
        Scanner enterName = new Scanner(System.in);
        String name = enterName.nextLine();
        LocalDate dateTime = LocalDate.now(ZoneId.systemDefault());
        LocalDate dateNow =
        switch (dateTime) {

            case dateTime >

        }
    }*/

    /**Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
     */
    public static int countNumberOne(int[] arr) {
        int count = 0;
        int max = 0;

        for (int elem : arr) {
            if (elem == 0) {
                count = 0;
            } else {
                count++;
            }
            if (max <= count) {
                max = count;
            }
        }
        return max;
    }

    /**
     * Дан массив nums = [3,2,2,3] и число val = 3.
     * Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
     * Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного
     * , а остальные - равны ему.
     */
    public static int[] arrChangeNoEnd(int[] arr) {
        int val = 3;
        int buffer = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == val) {
                buffer = arr[i];
                arr[i] = arr[i + 1];
                arr[i+1] = buffer;
            }
        }
        return arr;
    }
    /**
     * Напишите метод, который находит самую длинную строку общего префикса среди массива строк.
     * Если общего префикса нет, вернуть пустую строку "".
     */
    public static void longestCommonPrefix() {
        String[] str = {"helfhlo", "helJavhel", "helWohelgfrld "};
        if (str.length == 0) {
            System.out.println("Нет общего префикса!");
        }
        String prefix = str[0];

        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        System.out.println(prefix);
    }

    /**
     * Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
     */
    public static void stringRevers() {
        String str = "Добро пожаловать на курс по Java";

        String result = new StringBuilder(str).reverse().toString();

        System.out.println(result);
    }

    public static void stringRevers2() {
        String[] str = "Добро пожаловать на курс по Java".split("\\s");
        String rev = "";
        for (int i = str.length - 1; i >= 0; i--) {
            rev = rev + str[i] + " ";
        }
        System.out.println(rev);
    }
    public static void pushNumNoEnd(int[] arr, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] != 3) {
                arr[count++] = arr[i];
            }
        }
        while (count < len){
            arr[count++] = 3;
        }
    }

}





