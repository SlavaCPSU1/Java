package Java;// 1. Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
// 2. Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
// 3. *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
//    используем метод StringBuilder.append().
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
// 6. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7. *Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.


import java.util.Scanner;

public class Main2 {
    public static String firstWord;
    public static String secondWord;
    public static void main(String[] args) {
        isContain();

        isReverse();

        Scanner scn = new Scanner(System.in);
        System.out.print("Введите слово для разворота с помощью рекурсии: ");
        String inputWord = scn.nextLine();
        System.out.println("Слово после разворота: " + reverseWithRecursion(inputWord));

        System.out.print("Введите первое число: ");
        int a = scn.nextInt();
        System.out.print("Введите второе число: ");
        int b = scn.nextInt();
        System.out.println(concatenateStr(a, b, "+", a+b));
        System.out.println(concatenateStr(a, b, "-", a-b));
        System.out.println(concatenateStr(a, b, "*", a*b));

        System.out.println("Первый способ замены '=' на 'равно':");
        System.out.println(wordInsert(concatenateStr(a, b, "+", a+b)));
        System.out.println(wordInsert(concatenateStr(a, b, "-", a-b)));
        System.out.println(wordInsert(concatenateStr(a, b, "*", a*b)));

        System.out.println("Второй способ замены '=' на 'равно':");
        System.out.println(wordInsertSecondVariant(concatenateStr(a, b, "+", a+b)));
        System.out.println(wordInsertSecondVariant(concatenateStr(a, b, "-", a-b)));
        System.out.println(wordInsertSecondVariant(concatenateStr(a, b, "*", a*b)));

        getMethodSpeed();
    }

    public static void isContain(){
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите первое слово: ");
        firstWord = scn.nextLine();
        System.out.print("Введите второе слово: ");
        secondWord = scn.nextLine();

        if (firstWord.contains(secondWord)) System.out.println("Первое слово содержит символы второго слова.");
        else if (secondWord.contains(firstWord)) System.out.println("Второе слово содержит символы первого слова.");
        else System.out.println("Вхождений не найдено.");
    }

    public static void isReverse(){
        if (firstWord.equals(new StringBuilder(secondWord).reverse().toString())) System.out.println("Слова являются вращением друг друга.");
        else System.out.println("Слова не являются вращением друг друга.");
    }

    public static String reverseWithRecursion(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseWithRecursion(str.substring(1)) + str.charAt(0);
    }

    public static String concatenateStr(int a, int b, String operator, int result){
        StringBuilder str = new StringBuilder("").append(a)
                .append(" " + operator + " ")
                .append(b)
                .append(" = ")
                .append(result);
        return str.toString();
    }

    public static String wordInsert(String str){
        StringBuilder builder = new StringBuilder(str);
        int begin = builder.indexOf("=");
        return builder.deleteCharAt(begin).insert(begin, " равно ").toString();
    }
    public static String wordInsertSecondVariant(String str) {
        StringBuilder builder = new StringBuilder(str);
        int begin = builder.indexOf("=");
        return builder.replace(begin, begin + "=".length(), "равно").toString();
    }

    public static void getMethodSpeed(){

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            builder.append("=");
        }
        long begin = System.currentTimeMillis();
        String str = builder.toString().replace("=", "равно");
        long end = System.currentTimeMillis();
        System.out.println("Время работы метода replace для String: " + (end - begin) + " мс.");



        begin = System.currentTimeMillis();
        for (int i = 0; i < 100000*5; i+=5) {
            builder.replace(i, i+1, "равно");
        }
        end = System.currentTimeMillis();
        System.out.println("Время работы метода replace для StringBuilder: " + (end - begin) + " мс.");

    }
}