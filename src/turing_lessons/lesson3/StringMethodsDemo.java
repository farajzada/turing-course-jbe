package turing_lessons.lesson3;

public class StringMethodsDemo {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1.toUpperCase();
        String s3 = s2.toLowerCase();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        String s4 = "Hello".toUpperCase();
        String substring = s4.substring(1);
        System.out.println(substring);

        String s = "    Hello World     \n\t    ";

        int index= -1;

        do {
            index = s.indexOf('l',index +1);
            if(index>-1){
                System.out.println(index);
            }
        }while(true);
    }
}
