package dz4;

import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


// * 2. Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.
public class Task2 {
    public static void main(String[] args) {
        int[] arr = CreateArr(8);
        LinkedList<Integer> list = CreateLinkedList(arr, 8);
        enqueue(list, 10);
        System.out.println(list);
        dequeue(list);
        first(list);

    }

    private static LinkedList<Integer> CreateLinkedList(int[] arr, int num) {
        arr = CreateArr(num);
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

    private static void enqueue(LinkedList<Integer> list, int num){
        list.addLast(num);
    }
    private static int dequeue(LinkedList<Integer> list){
        int num = 0;
        num = list.get(0);
        list.remove(0);
        System.out.println(list);
        return num;
    }
    private static int first(LinkedList<Integer> list){
        int num = 0;
        num = list.get(0);
        System.out.println(num);
        return num;
    }

}

