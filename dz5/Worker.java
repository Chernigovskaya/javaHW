package dz5;

import java.util.*;

/**
 2. Пусть дан список сотрудников:
 Иван Иванов
 Светлана Петрова
 Кристина Белова
 Анна Мусина
 Анна Крутова
 Иван Юрин
 Петр Лыков
 Павел Чернов
 Петр Чернышов
 Мария Федорова
 Марина Светлова
 Мария Савина
 Мария Рыкова
 Марина Лугова
 Анна Владимирова
 Иван Мечников
 Петр Петин
 Иван Ежов
 Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
 **/

public class Worker {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = CreateWorkHashMap();
        sortOfCount(nameMap);
    }

    private static Map<String, Integer> CreateWorkHashMap() {
        String people = "Иван Иванов " + "Светлана Петрова " + "Кристина Белова " + "Анна Мусина " + "Анна Крутова " + "Иван Юрин " + "Петр Лыков " + "Павел Чернов " +
                "Петр Чернышов " + "Мария Федорова " + "Марина Светлова " + "Мария Савина " + "Мария Рыкова " + "Марина Лугова " + "Петр Петин " +
                "Анна Владимирова " + "Иван Мечников " + "Иван Ежов ";
        Map<String, Integer> nameMap = new HashMap<>();
        String[] peopleList = people.split(" ");
        for (int i = 0; i < peopleList.length; i++) {
            if (i % 2 == 0) {

                if (nameMap.containsKey(peopleList[i])) {
                    nameMap.replace(peopleList[i], nameMap.get(peopleList[i]) + 1);
                } else {
                    nameMap.put(peopleList[i], 1);
                }
            }
        }
        System.out.println(nameMap);
        return nameMap;
        }
    private static void sortOfCount(Map<String, Integer> nameMap){
        Map<String, Integer> sortedNameMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : nameMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : nameMap.entrySet()) {
                String key = entry.getKey();
                if (nameMap.get(key) == i) {
                    sortedNameMap.put(key, nameMap.get(key));
                }
            }
        }
        System.out.println(sortedNameMap);
    }
}



