package turing_lessons.lesson7;

public class DemoApp {
    public static void main(String[] args) {
        int a = 15;
        int b = 6;
        System.out.println(a / b);
        System.out.println(a % b);

        int x = 12;
        int y = 4;
        boolean l = (y > 4) && (2 < x);
        boolean l1 = (y > 4) || (2 < x);
        System.out.println("l = " + l);
        System.out.println("l = " + l1);

        int  b1 = 8+8*4;
        System.out.println(b1);

        float b2 = 15.0f;
        float d2 = 10.0f;
        double c = d2/b2;
        System.out.println("MUrad fwejfewkflw = " + c);

        boolean j = false;
        boolean m = 5 >= 5;
        boolean n = j || m;
        System.out.println("n = " + n);

        int aa = 12;
        int bb = 40;
        int cc = 8;
        int ff = aa * 4 / cc * (bb - 37);
        System.out.println("f = " + ff);
    }
}
