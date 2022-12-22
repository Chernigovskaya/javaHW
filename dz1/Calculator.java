package dz1;

import seminar4.ArrayStack;

import java.io.IOException;
import java.util.logging.*;

import java.util.Scanner;
//Реализовать простой калькулятор
public class Calculator {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = reader.nextDouble();
        System.out.print("Введите оператор (+, -, *, /): ");
        char operator = reader.next().charAt(0);
        System.out.print("Введите второе число: ");
        double num2 = reader.nextDouble();
        double ans = calculator(num1, num2, operator);

        ArrayStack<Double> myStack = new ArrayStack();


        myStack.push(ans);
        System.out.println("Если хотите отменить действие введите 'del'");
        System.out.println("Для выхода из калькулятора введите 'exit'");
        Scanner scanner = new Scanner(System.in);
        String back = scanner.next();
        if (back.equals("del")){
            myStack.pop();
        }
        if (back.equals("exit")) {
            Logger logger = Logger.getLogger(Calculator.class.getName());
            logging(logger);
            logger.log(Level.INFO, "Ввели: " + num1 + operator + num2 + " = " + ans);
        }
    }
    private static void logging(Logger logger) {
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
    }
    private static double calculator(double num1, double num2,  char operator) {
        double ans;
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
                return 0;
        }
        System.out.print("результат:\n");
        System.out.printf(num1 + " " + operator + " " + num2 + " = " + ans + '\n');
        return ans;
    }

}
