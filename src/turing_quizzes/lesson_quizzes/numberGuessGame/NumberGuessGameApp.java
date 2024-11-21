package turing_quizzes.lesson_quizzes.numberGuessGame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGameApp {

    /**
    * scanner
    * random
    * add int array
    * x green , y yellow
    * */
    public static void main(String[] args) {
        // creating numbers
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomNum = rand.nextInt(90000) + 10000;
        System.out.println(randomNum);
        int enteredNumber = scanner.nextInt();
        int[] randomNumberArray = new int[5];
        int[] myNumberArray = new int[5];



        // check randomNumber
        for (int i = 0; i < randomNumberArray.length; i++) {
            int digit = randomNum%10;
            randomNum = randomNum/10;
            randomNumberArray[randomNumberArray.length-(i+1)] = digit;
        }

        // check local NumberArray
        for (int i = 0; i < myNumberArray.length; i++) {
            int digit = enteredNumber%10;
            enteredNumber = enteredNumber/10;
            myNumberArray[myNumberArray.length-(i+1)] = digit;
        }


        // equals numbers
        if (Arrays.equals(randomNumberArray, myNumberArray)) {
            System.out.println("Equals ");
            System.exit(0);
        }


        for (int i = 0; i < randomNumberArray.length; i++) {
            for (int j = 0; j < randomNumberArray.length; j++) {
                if (myNumberArray[i] == randomNumberArray[j] && i==j) { // deyerleri ve indeksleri beraberdise
                    System.out.println(myNumberArray[i] + "Green");
                }else if (myNumberArray[i] == randomNumberArray[j] && i!=j) { // deyerler beraber indeksler ferqlidise bla bla bla
                    System.out.println(myNumberArray[i]+"Yellow");
                }
            }
        }
    }

}
