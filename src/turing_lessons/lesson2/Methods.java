package turing_lessons.lesson2;

public class Methods {
    public static int square(int num) {

        // return statement
        return num * num;
    }

    public static void main(String[] args) {
        int result;

        // call the methodd
        // store returned value to result
        result = square(10);

        System.out.println("Squared value of 10 is: " + result);
    }
}
