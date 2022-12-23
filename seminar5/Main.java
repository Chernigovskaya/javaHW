package seminar5;
// Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
//123456 Иванов
//321456 Васильев
//234561 Петрова
//234432 Иванов
//654321 Петрова
//345678 Иванов
//Вывести данные по сотрудникам с фамилией Иванов.
public class Main {
    public static void main(String[] args) {
        personPassportNumber();

    }
    public static void personPassportNumber() {
        Passport people = new Passport();
        people.add("Васильев", 321456);
        people.add("Петрова", 234561);
        people.add("Иванов", 234432);
        people.add("Петрова", 654321);
        people.add("Иванов", 345678);

        System.out.println(people.find("Петрова"));
    }
}
