package Java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//        1. Ввод с консоли в формате Ф.И.О Возраст пол
//        2. Выход из режима ввода по горячей кнопке
//        3. Вывод несортированного списка в формате Иванов И.И.
//        4. Два варианта продолжения, либо вывод списка сортированного по возрасту либо завершение приложения.
public class Main4 {

    public static void sort(ArrayList<Integer> age, LinkedList<Integer> index){
        ArrayList<Integer> ageTmp = new ArrayList<>(age);
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < ageTmp.size() - 1; i++) {
                if(ageTmp.get(i) > ageTmp.get(i + 1)){
                    int temp = ageTmp.get(i);
                    ageTmp.set(i, ageTmp.get(i + 1));
                    ageTmp.set(i + 1, temp);

                    int temp2 = index.get(i);
                    index.set(i, index.get(i + 1));
                    index.set(i + 1, temp2);
                    isSorted = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();

        Scanner scn = new Scanner(System.in);
        System.out.println("Введите ФИО, возраст, пол через пробел.");

        while (true) {
            String input = scn.nextLine();
            if (input.equals("q")) {
                break;
            } else {
                String[] data = input.split(" ");
                index.add(lastName.size());
                lastName.add(data[0]);
                firstName.add(data[1]);
                patronymic.add(data[2]);
                age.add(Integer.parseInt(data[3]));
                gender.add(data[4]);
            }
        }
        System.out.println("Вывод неотсортированного списка: ");
        for (int i = 0; i < lastName.size(); i++) {
            StringBuilder str = new StringBuilder();
            str.append(lastName.get(i)).append(" ").append(firstName.get(i).charAt(0)).append(". ").append(patronymic.get(i).charAt(0)).append(". ").append(age.get(i)).append(" ").append(gender.get(i));
            System.out.println(str);
        }

        System.out.println("-".repeat(10));

        while (true){
            System.out.println("Введите sort - для вывода сортированного по возрасту списка, q - для выхода: ");
            String input = scn.nextLine();
            if (input.equals("sort")){
                System.out.println("Вывод списка, отсортированного по возрасту: ");
                sort(age, index);

                for (int i: index) {
                    StringBuilder str = new StringBuilder();
                    str.append(lastName.get(i)).append(" ").append(firstName.get(i).charAt(0)).append(". ").append(patronymic.get(i).charAt(0)).append(". ").append(age.get(i)).append(" ").append(gender.get(i));
                    System.out.println(str);
                }
            } else if (input.equals("q")){
                break;
            }
        }



    }
}