package dz6;

import java.util.*;

public class Laptop {
    /**
     * модель ноутбука
     */
    private String model;
    /**
     * операционная система
     */
    private String os;

    /**
     * бщий объем твердотельных накопителей (SSD), ГБ
     */
    private String ssd;
    /**
     * цвет
     */
    private String color;
    /**
     * Объем оперативной памяти
     */
    private String amountOfRAM;

    public Laptop(String model, String os, String ssd, String color, String amountOfRAM) {
        this.model = model;
        this.os = os;
        this.ssd = ssd;
        this.color = color;
        this.amountOfRAM = amountOfRAM;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", os='" + os + '\'' +
                ", ssd=" + ssd +
                ", color='" + color + '\'' +
                ", amountOfRAM=" + amountOfRAM +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return model.equals(laptop.model) && os.equals(laptop.os) && Objects.equals(ssd, laptop.ssd) && Objects.equals(color, laptop.color) && Objects.equals(amountOfRAM, laptop.amountOfRAM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, os);
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }


    public String getSsd() {
        return ssd;
    }

    public String getColor() {
        return color;
    }

    public String getAmountOfRAM() {
        return amountOfRAM;
    }
    public static String scanner() {
        Scanner scanner = new Scanner(System.in);
        String scan = scanner.nextLine();
        return scan;
    }

    public static Map<String, String> filter() {
        Map<String, String> resFilter = new HashMap<>();
        System.out.println(
                "Введите цифру, соответствующую необходимому критерию сортировки: \n 1 - по ОЗУ \n 2 - по объему ЖД \n 3 - по операционной системе \n 4 - по цвету");
        String key = scanner();

        System.out.println("Введите значения для выбранного критерия: ");
        String value = scanner().toLowerCase();
        resFilter.put(key, value);
        System.out.println(resFilter);
        return resFilter;
    }
    public static void sort(Map<String, String> criterias, Set<Laptop> laptops) {

        Set<Laptop> filter = new HashSet<>(laptops);
        for (Laptop laptop : laptops) {
            for (Object pair1 : criterias.keySet()) {
                if (pair1.equals("1") && !laptop.getSsd().equals(criterias.get(pair1))) {
                    filter.remove(laptop);
                }
                for (Object pair2 : criterias.keySet()) {
                    if (pair1.equals("2") && !laptop.getAmountOfRAM().equals(criterias.get(pair2))) {
                        filter.remove(laptop);

                    }
                    for (Object pair3 : criterias.keySet()) {
                        if (pair2.equals("3") && !laptop.getOs().equals(criterias.get(pair3))) {
                            filter.remove(laptop);

                        }
                        for (Object pair4 : criterias.keySet()) {
                            if (pair3.equals("4") && !laptop.getColor().equals(criterias.get(pair4))) {
                                filter.remove(laptop);
                            }
                        }
                    }
                }
            }
        }
        if (filter.isEmpty()) {
            System.out.println("По введенным критериям ничего не найдено!");
        }
        else {
            System.out.println("Вот что мы можем предложить: \n" + filter.toString());
        }
    }

}
