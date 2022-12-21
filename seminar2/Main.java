package seminar2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        //fillWithCharacters(6);
//        changeString();
//        String str = "ada";
//        System.out.println(isPalindrome(str));
//        createTestString();
        checkFileFolders();

    }
    /**
     * Дано четное число N (>0) и символы c1 и c2.
     * Написать метод, который вернет строку длины N,
     * которая состоит из чередующихся символов c1 и c2, начиная с c1
     */
    public static void fillWithCharacters(int n) {
        StringBuilder result = new StringBuilder();
        if(n == 0 ) {
            System.out.println("Введите число, которое не равно 0!");
            return;
        }
        if(n <= 0 || n % 2 != 0) {
            System.out.println("Число является не четным или меньше 0!");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                result.append("c1");
            } else {
                result.append("c2");
            }
        }
        System.out.println(result);
    }
    /**
     * Напишите метод, который сжимает строку. Пример: вход aaaabbbcdd.
     */
    private static void changeString(){
        String inPut = "aaaabbbcdd";
        StringBuilder result = new StringBuilder();

        int runLen = 1;
        char runChar = inPut.charAt(0);

        for (int i = 1; i < inPut.length(); i++) {
            if(inPut.charAt(i) == runChar) {
                ++runLen;
            } else {
                result.append(runChar).append(runLen);
                runLen = 1;
                runChar = inPut.charAt(i);
            }
        }

        result.append(runChar).append(runLen);
        System.out.println(result);
    }
    /**
     * Напишите метод, который принимает на вход строку (String)
     * и определяет является ли строка палиндромом (возвращает boolean значение).
     */
    private static boolean isPalindrome(String str) {
        int n = str.length();

        for(int i = 0; i < (n/2); i++){
            if (str.charAt(i) != str.charAt(n -i -1)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
     * который запишет эту строку в простой текстовый файл, обработайте исключения.
     */
    public static void createTestString() {
        String str = "TEST".repeat(100);

        try (PrintWriter out = new PrintWriter("testWrite.txt")) {
            out.println(str);
            int a = 1 / 0;
            System.out.println(a);
        }catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Напишите метод, который вернет содержимое
     * текущей папки в виде массива строк. Напишите метод, который запишет массив,
     * возвращенный предыдущим методом в файл.
     * Обработайте ошибки с помощью try-catch конструкции.
     * В случае возникновения исключения, оно должно записаться в лог-файл.
     */
    private static void checkFileFolders() {
        File file = new File("C:\\");
        ArrayList<File> files = new ArrayList<>(Arrays.asList(file.listFiles()));

        try(PrintWriter out = new PrintWriter("fileFolders.txt")) {
            out.println(files);
            logger.info("Содержимое текущих папок записано в файл fileFolders.txt");
        } catch (FileNotFoundException e) {
            logger.info(e.getMessage());
        }
    }
}
