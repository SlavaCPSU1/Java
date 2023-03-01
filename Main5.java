package Java;

// Создать множество, ключ и значение строки. Добавить шесть элементов. Вывести в консоль значения.
// Добавить ко всем значениям символ "!".
// Создать второе множество с таким же обобщением. Ключи второго множества частично совпадают с ключами первого.
// Объеденить значания во втором множестве и первом если ключи совпадают. Вывести результат в консоль.


import java.util.HashMap;

public class Main5 {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMapCountries = new HashMap<>();
        hashMapCountries.put(0, "Россия");
        hashMapCountries.put(1, "Германия");
        hashMapCountries.put(2, "Канада");
        hashMapCountries.put(3, "Сингапур");
        hashMapCountries.put(4, "США");
        hashMapCountries.put(5, "Китай");

        System.out.println("Первое множество: ");
        hashMapCountries.forEach((k, v) -> System.out.println("[" + k + ": " + v + "]"));

        System.out.println("-".repeat(10));
        System.out.println("Измененное первое множество:");
        for (Integer key: hashMapCountries.keySet()) {
            hashMapCountries.compute(key, (k, v) -> v += "!");
        }
        hashMapCountries.forEach((k, v) -> System.out.println("[" + k + ": " + v + "]"));

        System.out.println("-".repeat(10));
        HashMap<Integer, String> hashMapCapitalCities = new HashMap<>();
        hashMapCapitalCities.put(0, "Москва");
        hashMapCapitalCities.put(2, "Оттава");
        hashMapCapitalCities.put(6, "Вена");
        hashMapCapitalCities.put(8, "Каир");
        hashMapCapitalCities.put(3, "Сингапур");
        hashMapCapitalCities.put(5, "Пекин");
        System.out.println("Второе множество:");
        hashMapCapitalCities.forEach((k, v) -> System.out.println("[" + k + ": " + v + "]"));

        System.out.println("-".repeat(10));
        HashMap<Integer, String> overallHashMap = new HashMap<>(hashMapCountries);
        overallHashMap.putAll(hashMapCapitalCities);
        System.out.println("Объединение множеств:");
        for (Integer key: overallHashMap.keySet()) {
            if (hashMapCountries.containsKey(key) && hashMapCapitalCities.containsKey(key)){
                overallHashMap.compute(key, (k, v) -> v = hashMapCountries.get(key) + " - " + v);
            }
        }

        overallHashMap.forEach((k, v) -> System.out.println("[" + k + ": " + v + "]"));

    }
}