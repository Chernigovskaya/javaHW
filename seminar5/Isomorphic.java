package seminar5;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет.
// Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
//1. повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
//2. буква может не меняться, а остаться такой же. (Например, note - code)
//Пример 1:
//Input: s = "foo", t = "bar"
//Output: false
//Пример 2:
//Input: s = "paper", t = "title"
//Output: true
public class Isomorphic {
    public static void main(String[] args) {
        String X = "paper";
        String Y = "title";

        if (isIsomorphic(X, Y)) {
            System.out.println(X + " and " + Y + " are Isomorphic");
        }
        else {
            System.out.println(X + " and " + Y + " are not Isomorphic");
        }
    }
    public static boolean isIsomorphic(String X, String Y) {
        // базовый вариант
        if (X == null || Y == null) {
            return false;
        }

        // если 'X' и 'Y' имеют разную длину, они не могут быть изоморфны
        if (X.length() != Y.length()) {
            return false;
        }

        // используем карту для хранения сопоставления символов строки 'X' со строкой 'Y'
        Map<Character, Character> map = new HashMap<>();

        // используем set для хранения пула уже сопоставленных символов
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < X.length(); i++)
        {
            char x = X.charAt(i), y = Y.charAt(i);

            // если 'x' был замечен раньше
            if (map.containsKey(x))
            {
                // вернуть false, если первое вхождение `x` сопоставлено с
                // другой символ
                if (map.get(x) != y) {
                    return false;
                }
            }

            // если 'x' виден в первый раз (т.е. он еще не отображен)
            else {
                // вернуть false, если 'y' уже сопоставлен с каким-то другим символом в 'X'
                if (set.contains(y)) {
                    return false;
                }

                // сопоставляем 'y' с 'x' и помечаем его как сопоставленный
                map.put(x, y);
                set.add(y);
            }
        }
        return true;
    }

}

