package dz4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 * 3. В калькулятор добавьте возможность отменить последнюю операцию.
 */
public class Main {
    public static void main(String[] args) {

        LinkedListRevers();
    }

    private static void LinkedListRevers() {
        List<Integer> arr = CreateLinkedList();
        List<Integer> revers = new LinkedList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            revers.add(arr.get(i));
        }
        System.out.println(revers);
    }

    private static LinkedList<Integer> CreateLinkedList() {
        int[] arr = CreateArr(10);
        LinkedList<Integer> list = new LinkedList<>();
        for (Integer i : arr) {
            list.add(i);
        }
        System.out.println(list);
        return list;
    }

    private static int[] CreateArr(int num) {
        int[] arr = new int[num];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }
}


