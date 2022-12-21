package dz3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] arr = array();
//        System.out.println(Arrays.toString(sort(arr)));

//        zadacha2();
        zadacha3();

    }

    // Реализовать алгоритм сортировки слиянием
    private static int[] sort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    private static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        //уже отсортирован
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

        //слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    private static int[] array() {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10, 50);
        }
        return array;
    }
    // Пусть дан произвольный список целых чисел, удалить из него четные числа

    private static void zadacha2() {
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int val = random.nextInt(10, 100);
            arr.add(val);
        }
        System.out.println(Arrays.asList(arr));
        for (int i = 0; i < arr.size(); ) {
            if (arr.get(i) % 2 == 0) {
                arr.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.asList(arr));
    }

    private static void zadacha3() {
        // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int val = random.nextInt(10, 100);
            arr.add(val);
        }
        System.out.println(Arrays.asList(arr));
        Collections.sort(arr);
        int min = arr.get(0);
        int max = arr.get(arr.size() -1);
        int mean = 0;
        for (int i = 0; i < arr.size(); i++) {
            mean = mean + arr.get(i);
        }
        mean = mean / arr.size();
        System.out.println();
        System.out.println(Arrays.asList(arr));
        System.out.println("Минимальный элемент = " + min);
        System.out.println("Максимальный элемент = " + max);
        System.out.println("Среднее значение списка = " + mean);
    }

}