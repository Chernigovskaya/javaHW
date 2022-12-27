package seminar6;

import java.util.Objects;

public class Cat {
    /**
     * Имя кошки
     */
    private String name;
    /**
     * возраст кошки
     */
    private int age;

    /**
     * цвет кошки
     */
    private String color;
    /**
     * номер пасспорта вакинации кошки
     */
    private int passportVaccinationsNumber;

    public Cat(String name, int age, String color, int passportVaccinationsNumber) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.passportVaccinationsNumber = passportVaccinationsNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public int getPassportVaccinationsNumber() {
        return passportVaccinationsNumber;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", passportVaccinationsNumber=" + passportVaccinationsNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && passportVaccinationsNumber == cat.passportVaccinationsNumber && name.equals(cat.name) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }
}