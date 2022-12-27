package dz6;

import java.util.*;

/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * 2. Создать множество ноутбуков.
 * 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * 1. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * 2. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */



public class Main {
    public static void main(String[] args) {
        Set<Laptop> laptop = createLaptor();
        Set<Laptop> laptops = new HashSet<>(laptop);

        Map<String, String> sel = Laptop.filter();
        Laptop.sort(sel, laptops);
    }

    private static Set<Laptop> createLaptor() {
        Laptop laptop1 = new Laptop("irbis NB257", "windows", "0", "black", "4");
        Laptop laptop2 = new Laptop("lenovo IdeaPad 3 15IGL05", "linux", "128", "white", "4");
        Laptop laptop3 = new Laptop("lenovo IdeaPad 3 15IGL05", "без ОС", "128", "white", "4");
        Laptop laptop4 = new Laptop("asus ExpertBook B1400CEAE-EB2895", "без ОС", "256", "black", "8");
        Laptop laptop5 = new Laptop("hiper DZEN MTL1569", "linux", "256", "white", "8");
        Laptop laptop6 = new Laptop("huawei MateBook 14 KLVL-W56W", "windows", "512", "white", "16");


        Set<Laptop> setLaptop = new HashSet<>();

        setLaptop.add(laptop1);
        setLaptop.add(laptop2);
        setLaptop.add(laptop3);
        setLaptop.add(laptop4);
        setLaptop.add(laptop5);
        setLaptop.add(laptop6);
//        System.out.println(setLaptop);
        return setLaptop;
    }


}
