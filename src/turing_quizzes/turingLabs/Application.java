package turing_quizzes.turingLabs;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Movie[] movies = new Movie[0];

        while (true) {
            System.out.println("Please enter the number: \n" +
                    "1.Input movies\n" +
                    "2.Display movies and rating\n" +
                    "3.Add more movie\n" +
                    "0.Exit\n");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    movies = addMovie(3, movies);
                    break;
                case 2:
                    displayMovies(movies);
                    break;
                case 3:
                    System.out.println("How many movies would you like to add?");
                    int number = input.nextInt();
                    movies = addMovie(number, movies);
                    break;


            }
        }

    }

    public static Movie[] addMovie(int n, Movie[] movies) {
        Scanner scanner = new Scanner(System.in);
        Movie[] newMovies = new Movie[n + movies.length];
        for (int i = 0; i < newMovies.length; i++) {
            if (i < movies.length) {
                newMovies[i] = movies[i];
            } else {
                System.out.println("Enter movie name:");
                String movieName = scanner.next();
                System.out.println("Enter movie rating:");
                double movieRating = scanner.nextDouble();
                Movie movie = new Movie(movieName, movieRating);
                newMovies[i] = movie;
                System.out.println("Successfully added movie");
            }

        }
        return newMovies;
    }

    public static void displayMovies(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i].getName() + "\t" + movies[i].getRating());
        }
    }


}
