package dz1;

import java.io.IOException;
import java.util.logging.*;

import java.util.Scanner;
//Реализовать простой калькулятор
public class Calculator {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Calculator.class.getName());

        try {
            FileHandler fh = new FileHandler("calcLog.txt", true);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);
            logger.addHandler(fh);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.", e);
        }

        double num1;
        double num2;
        double ans;
        char operator;
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        num1 = reader.nextDouble();
        System.out.print("Введите оператор (+, -, *, /): ");
        operator = reader.next().charAt(0);
        System.out.print("Введите второе число: ");
        num2 = reader.nextDouble();
        switch (operator) {
            case '+':
                ans = num1 + num2;
                break;
            case '-':
                ans = num1 - num2;
                break;
            case '*':
                ans = num1 * num2;
                break;
            case '/':
                ans = num1 / num2;
                break;
            default:
                System.out.println("Ошибка! Вы ввели некорректные данные");
                return;
        }
        System.out.print("результат:\n");
        System.out.printf(num1 + " " + operator + " " + num2 + " = " + ans + '\n');

        logger.log(Level.INFO,"num1 = " + num1  + ", " + "operator = " + "'" + operator + "'" + ", " + "num2 = " + num2  + ", " + "результат равен: " + ans);

    }
}
