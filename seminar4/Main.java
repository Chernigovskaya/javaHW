package seminar4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        splitString();
        int[] arr = {1,4,3,5,6,7};
        addStackArray(arr);
        System.out.println("\n");
        addQueueArray(arr);
    }

    /**
     * Реализовать консольное приложение, которое:
     * 1. Принимает от пользователя строку вида
     * text~num
     * 1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
     * 2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
     */
    private static void splitString() {
        int num;
        String str;
        String text;
        str = getScanner();


        String[] words = str.split("~");
        text = words[0];
        num = Integer.parseInt(words[1]);

        List<String> list = getStrings(num, text);
        System.out.println(list);

        System.out.println("Введите строку вида print~num: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println("Получили результат: ");

        words = str.split("~");
        num = Integer.parseInt(words[1]);
        list.remove(num);

        System.out.println(list);
    }

    private static String getScanner() {
        String str;
        System.out.println("Введите строку вида text~num: ");
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        System.out.println("Получили результат: ");
        return str;
    }

    private static List<String> getStrings(int num, String text) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            if(num != 0) {
                list.add(i, "default");
                if(num == i) {
                    list.add(num, text);
                }
            }
        }
        return list;
    }

    /**
     * 📔 1) Написать метод, который принимает массив элементов, помещает их в стэк и
     * выводит на консоль содержимое стэка.
     * 2) Написать метод, который принимает массив элементов, помещает их в очередь и
     * выводит на консоль содержимое очереди.
     */
    private static void addStackArray(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            stack.push(array[i]);
        }

        System.out.println("\n");

        for (int i = 0; i < array.length; i++) {
            System.out.println(stack.pop());
        }
    }

    private static void addQueueArray(int[] array) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            queue.add(array[i]);
            System.out.println(array[i]);
        }
        System.out.println("\n");
        for (int i = 0; i < array.length; i++) {
            System.out.println(queue.pop());
        }
    }

    /**
     * 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
     * 2. Реализуйте очередь с помощью LinkedList со следующими методами:enqueue() - помещает элемент в конец очереди, dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.
     * 3. В калькулятор добавьте возможность отменить последнюю операцию.
     */

}
