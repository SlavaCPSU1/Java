package Java;

//        Разработать программу, имитирующую поведение коллекции HashSet.
//        В программе создать метод add добавляющий элемент, метод toString возвращающий строку с элементами множества
//        и метод позволяющий читать элементы по индексу. Формат данных Integer.

import java.util.ArrayList;
import java.util.HashMap;


public class Main6 {
    public static void main(String[] args) {
        MySet set = new MySet();
        set.add(5);
        set.add(2);
        set.add(3);
        set.add(5);
        set.add(5);
        set.add(10);
        set.add(7);
        System.out.println(set.toString());
        System.out.println((set.contains(5)));
        System.out.println(set.get(2));
        System.out.println(set.getArrayList());
        System.out.println((set.tailSet(5)));
        System.out.println((set.headSet(5)));
        System.out.println((set.subSet(7, 3)));

    }
}
class MySet{
    private HashMap<Integer, Object> values = new HashMap();
    private static final Object X = new Object();
    void add (int data){
        values.put(data, X);
    }
    public String toString() {
        return values.keySet().toString();
    }

    Boolean contains(int data){
        return values.containsKey(data);
    }

    void clear() {
        values.clear();
    }

    void remove(int data){
        values.remove(data);
    }
    int size() {
        return values.size();
    }


    int get(int index) {
        return (int) values.keySet().toArray()[index];
    }

    ArrayList getArrayList(){
        ArrayList<Integer> res = new ArrayList<>();
        values.forEach((k, v) -> res.add(k));
        return res;
    }
    MySet headSet(int data){
        MySet res = new MySet();
        for (int el: values.keySet()){
            res.add(el);
            if (data == el)
                break;
        }
        return res;
    }

    MySet tailSet(int data){
        boolean ad = false;
        MySet res = new MySet();
        for (int el: values.keySet()) {
            if (data == el)
                ad = true;
            if (ad) {
                res.add(el);
            }
        }
        return res;
    }


    MySet subSet (int key1, int key2){
        MySet res = new MySet();
        boolean ad = false;
        int stop = key1;
        for (int el: values.keySet()) {
            if (el == key1 && !ad){
                ad = true;
                stop = key2;
            }
            if (el == key2 && !ad){
                ad = true;
            }
            if (ad){
                res.add(el);
                if (el == stop){
                    break;
                }
            }
        }
        return res;
    }
}
