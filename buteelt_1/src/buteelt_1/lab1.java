package buteelt_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class lab1 {
    public static void main(String[] args) {
        // 1. List үүсгэх
        List<String> myList = new ArrayList<>();

        // 2. Элемент нэмэх
        myList.add("Java");
        myList.add("Python");
        myList.add("C++");
        myList.add("JavaScript");

        // 3. Элемент хасах
        myList.remove("C++");

        // 4. Элемент хайх
        boolean containsJava = myList.contains("Java");
        System.out.println("Java хэл байгаа эсэх'? " + containsJava);

        // 5. Элементийг олох
        String language = myList.get(0);
        System.out.println("Анхны ашигласан хэл бол: " + language);

        // 6. List-ийн хэмжээг олгох
        int size = myList.size();
        System.out.println("List-ны хэмжээ : " + size);

        // 7. List-ийг эрэмбэлэх
        Collections.sort(myList);
        System.out.println("Доторх хэлнүүд: " + myList);
    }
}
