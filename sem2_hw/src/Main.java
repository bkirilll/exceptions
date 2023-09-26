import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

public class Main {
    public static void main(String[] args) {
        //floatSystemIn();
        //task2();
        //task3();
        task4();
    }

    public static float floatSystemIn() {
        boolean temp = true;
        BufferedReader bufferedReader = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        float number = 0f;
        while (temp) {
            System.out.println("Введите float число: ");

            try {
                number = Float.parseFloat(bufferedReader.readLine());
                System.out.println(number);
                temp = false;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Введите число");
            }
        }
        return number;
    }


    public static void task2() {
        try {
            int[] intArray = {1,2,3,4,5,6,7,8,9};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }


    public static void task4() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку");
        try {
            String str = bufferedReader.readLine();
            if(str.equals("")) throw new RuntimeException("Пустую строку вводить нельзя");
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}