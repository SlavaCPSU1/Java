package Java;

import java.util.*;
// 1. Создать новый список, добавить несколько строк с названиями цветов и вывести коллекцию на экран.
// 2. Итерация всех элементов списка цветов и добавления к каждому символа '!'.
// 3. Вставить элемент в список в первой позиции.
// 4. Извлечь элемент (по указанному индексу) из заданного списка.
// 5. Обновить определенный элемент списка по заданному индексу.
// 6. Удалить третий элемент из списка.
// 7. Поиска элемента в списке по строке.
// 8. Создать новый список и добавить в него несколько елементов первого списка.
// 9. Удалить из первого списка все элементы, отсутствующие во втором списке.
// 10. *Сортировка списка.
// 11. *Сравнить время работы тысячи повторений пункта 3 для ArrayList и LinkedList.

public class Main3 {
    public static void main(String[] args) {

        // 1.
        List<String> list = new ArrayList<>();
        list.add("Ирисы");
        list.add("Нарциссы");
        list.add("Лютики");
        list.add("Подсолнухи");
        list.add("Гортензии");
        System.out.println("Первоначальный список: " + list);

        // 2.
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + '!');
        }
        System.out.println("Список после добавления символа '!': " + list);

        // 3.
        list.add(0, "Маки");
        System.out.println("Список после добавления элемента на первую позицию: " + list);

        // 4.
        System.out.print("Введите индекс элемента: ");
        Scanner scn = new Scanner(System.in);
        int index = scn.nextInt();
        System.out.println("По данному индексу находится элемент: " + list.get(index));

        // 5.
        System.out.print("Введите индекс элемента, который хотите обновить: ");
        index = scn.nextInt();
        System.out.print("Введите новые данные: ");
        scn.nextLine();
        String newElement = scn.nextLine();
        list.set(index, newElement);
        System.out.println(list);

        // 6.
        System.out.println("Удалён третий элемент: " + list.remove(2));
        System.out.println(list);

        // 7.
        System.out.print("Введите элемент для поиска: ");
        String input = scn.nextLine();
        System.out.println("Индекс искомого элемента: " + list.indexOf(input));

        // 8.
        List<String> list2 = new ArrayList<>();
        list2.add(list.get(0));
        list2.add(list.get(2));
        list2.add(list.get(3));
        System.out.println("Новый список с элементами из первого списка: " + list2);

        // 9.
        list.retainAll(list2);
        System.out.println("Удалены отсутствующие элементы: " + list);


        // 10.
        Collections.sort(list);
        System.out.println("Отсортированный список: " + list);

        // 11.

        LinkedList<String> lList = new LinkedList<>();
        lList.clone();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            lList.add(0, "Маки");
        }
        long end = System.currentTimeMillis();
        System.out.println("Время работы для LinkedList: " + (end - begin));

        begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0, "Маки");
        }
        end = System.currentTimeMillis();
        System.out.println("Время работы для ArrayList: " + (end - begin));
    }
}