package dz1;

public class Main {
    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(sumNumber(4));
        //printNumber(1000);

    }
    // Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)
    public static int factorial(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
    public static int sumNumber(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + i;
        }
        return result;
    }


    // Вывести все простые числа от 1 до 1000
    public static void printNumber(int n) {

        for (int j = 2; j <= n; j++) {
            boolean simple = false;

            for (int i = 2; i * i <= j; i++) {
                simple = (j % i == 0);
                if (simple) {
                    break;
                }
            }
            if (!simple) {
                System.out.print(j + " ");
            }
        }
    }
}
