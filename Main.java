
// Первый семинар.
// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
// 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
// 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

// Пункты реализовать в методе main
// *Пункты реализовать в разных методах

// int i = new Random().nextInt(k); //это кидалка случайных чисел!)





package Java;


import java.util.Random;

public class Main {

    static int number = new Random().nextInt(2000);

    public static void main(String[] args) {
        System.out.println("Выброшенное число: " + number);
        System.out.println("Старший значащий бит выпавшего числа: " + getMostSignificantBit() + "\n");
        getFirstArray();
        System.out.println("\n");
        getSecondArray();
    }

    public static int getMostSignificantBit() {
        int n = 0;
        while ((int) Math.pow(2, n) <= number) {
            n++;
        }
        n -= 1;
        return n;
    }

    public static void getFirstArray() {
        int count = 0;
        for (int i = number; i < Short.MAX_VALUE ; i++) {
            if (i % getMostSignificantBit() == 0 ) count++;
        }
        System.out.println("Количество элементов массива m1: " + count);
        int[] m1 = new int[count];
        int k = 0;
        for (int i = number; i < Short.MAX_VALUE ; i++) {
            if (i % getMostSignificantBit() == 0) {
                m1[k] = i;
                k++;
            }
        }
        System.out.print("Массив m1: [");
        for (int i = 0; i < m1.length; i++) {
            if (i != m1.length - 1) System.out.print(m1[i] + ", ");
            else System.out.print(m1[i]);
        }
        System.out.print("]");
    }

    public static void getSecondArray() {
        int count = 0;
        for (int i = Short.MIN_VALUE; i < number; i++) {
            if (i % getMostSignificantBit() != 0 ) count++;
        }
        System.out.println("Количество элементов массива m2: " + count);
        int[] m2 = new int[count];
        int k = 0;
        for (int i = Short.MIN_VALUE; i < number; i++) {
            if (i % getMostSignificantBit() != 0) {
                m2[k] = i;
                k++;
            }
        }
        System.out.print("Массив m2: [");
        for (int i = 0; i < m2.length; i++) {
            if (i != m2.length - 1) System.out.print(m2[i] + ", ");
            else System.out.print(m2[i]);
        }
        System.out.print("]");
    }
}