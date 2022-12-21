package dz2;
import java.io.IOException;
import java.util.Arrays;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.json.JSONArray;
import org.json.JSONObject;


public class Main {
    public static void main(String[] args) {
//       zadacha2();
        zadacha1();
//        zadacha3();

    }
    public static void zadacha1() {
        /**
         Дана строка sql-запроса "select * from students where ".
         Сформируйте часть WHERE этого запроса, используя StringBuilder.
         Данные для фильтрации приведены ниже в виде json строки.
         Если значение null, то параметр не должен попадать в запрос.
         Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
         */

        JSONObject jo = new JSONObject("{ \"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\" }");
        String name = (String) jo.get("name");
        String country = (String) jo.get("country");
        String city = (String) jo.get("city");
        String age = (String) jo.get("age");
        if (age.contains("null")) {
            System.out.println("select * from students where name = " + name + ", country = " + country + ", city = " + city);
        }
        else  System.out.println("select * from students where name = " + name + ", country = " + country + ", city = " + city + ", age = " + age);
    }


    /**
     * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     */

    public static void zadacha2(){
        Logger logger = Logger.getLogger(dz1.Main.class.getName());
        try {
            FileHandler fh = new FileHandler("fileLog.txt");
            logger.addHandler(fh);
            SimpleFormatter sFormat = new SimpleFormatter();
            fh.setFormatter(sFormat);

        } catch (SecurityException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за политики безопасности.", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE,
                    "Не удалось создать файл лога из-за ошибки ввода-вывода.", e);
        }

        int[] arr = {10, 30, 5, 6, 40, 12, 25};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-i; j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
                logger.log(Level.INFO, " результат после каждой итерации: "  + Arrays.toString(arr));
            }

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void zadacha3()
    {
        JSONArray students = new JSONArray("[" +
                "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
        for (int i = 0; i < students.length(); i++)
        {
            StringBuilder name = new StringBuilder((String) students.getJSONObject(i).get("фамилия"));
            StringBuilder grade = new StringBuilder((String) students.getJSONObject(i).get("оценка"));
            StringBuilder subject = new StringBuilder((String) students.getJSONObject(i).get("предмет"));
            System.out.println("Студент " + name + " получил " + grade + " по предмету " + subject);
        }
    }

}
