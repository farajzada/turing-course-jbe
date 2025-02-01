package turing_lessons.lesson4;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList(); // Raw type (Generics istifadə olunmur)
//        list.add("Java");
//        list.add(10); // String gözlədiyimiz halda, rəqəm əlavə etdik
//
//        String value = (String) list.get(1); // Type Casting Error (ClassCastException)
//        System.out.println(value);

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java");
        // list.add(10);  // Compile-time error

        String value1 = list1.get(0); // Type casting lazım deyil
        System.out.println(value1);
    }

}
