package turing_quizzes.turingLabs.turingLabs01;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Movie[] movies = new Movie[0];
        while (true) {
            System.out.println("""
                    Please input the number:
                    1.Input 3 movies
                    2.Display movies
                    3.Add more movies
                    4.Display statistics
                    5.Search movies
                    6.Update movies rating
                    7.Delete movies
                    8.Sort movies
                    0.Exit program
                    
                    """);
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    movies = addMovies(3, movies);
                    break;
                case 2:
                    displayMovies(movies);
                    break;
                case 3:
                    System.out.println("How many movies would you like to add?");
                    int number = input.nextInt();
                    movies = addMovies(number, movies);
                    break;
                case 4:
                    calculateStatistics(movies);
                    break;
                case 5:
                    System.out.println("Enter the movie you want to find");
                    findMovie(movies, input.next());
                    break;
                case 6:
                    System.out.println("Enter the movie you want to update rating");
                    updateRating(movies, input.next());
                    break;
                case 7:
                    System.out.println("Enter the movie you want to delete movie");
                    movies = deleteMovie(movies, input.next());
                    break;
                case 8:
                    sortMovies(movies);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice");

            }
        }
    }

    public static Movie[] addMovies(int n, Movie[] movies) {
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
            }
        }
        return newMovies;
    }

    public static void displayMovies(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            System.out.println(movies[i].getName() + ":" + movies[i].getRating());
        }
    }

    public static void calculateStatistics(Movie[] movies) {
        if (movies.length == 0) {
            System.out.println("There is nothing to show");
            return;
        }
        int minIndex = 0;
        int maxIndex = 0;
        double sum = 0;
        for (int i = 0; i < movies.length; i++) {
            if (movies[minIndex].getRating() > movies[i].getRating()) {
                minIndex = i;
            }
            if (movies[maxIndex].getRating() < movies[i].getRating()) {
                maxIndex = i;
            }
            sum += movies[i].getRating();
        }
        System.out.println("Average rating is : " + sum / movies.length);
        System.out.println("Max rating is : " + movies[maxIndex].getRating() + " for movie " + movies[maxIndex].getName());
        System.out.println("Min rating is : " + movies[minIndex].getRating() + " for movie " + movies[minIndex].getName());
    }


    public static int findMovie(Movie[] movies, String name) {
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getName().equals(name)) {
                System.out.println("Movie found, rating is: " + movies[i].getRating());
                return i;
            }
        }
        System.out.println("Movie is not found");
        return -1;
    }

    public static void updateRating(Movie[] movies, String name) {
        int index = findMovie(movies, name);
        if (index >= 0) {
            System.out.println("Enter the new rating:   ");
            {
                Scanner scanner = new Scanner(System.in);
                double newRating = scanner.nextDouble();
                movies[index].setRating(newRating);
            }
        }
    }


    public static Movie[] deleteMovie(Movie[] movies, String name) {
        int index = findMovie(movies, name);
        if (index >= 0) {
            Movie[] newMovies = new Movie[movies.length - 1];
            System.arraycopy(movies, 0, newMovies, 0, index);
            System.arraycopy(movies, index + 1, newMovies, index, movies.length - index - 1);
            System.out.println("Movie deleted.");
            return newMovies;
        }
        return movies;
    }

    public static void sortMovies(Movie[] movies) {
        for (int i = 0; i < movies.length; i++) {
            for (int j = 0; j < movies.length - i - 1; j++) {
                if (movies[j].getRating() > movies[j + 1].getRating()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted");
        displayMovies(movies);
    }
}