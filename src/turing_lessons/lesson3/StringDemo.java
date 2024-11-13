package turing_lessons.lesson3;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 =  new String("Hello World");
        String s3 = s1 +s2 +"abc";
        String s4 = new String(new char[]{'a','b','c'});
        System.out.println(s3);

    }
}
