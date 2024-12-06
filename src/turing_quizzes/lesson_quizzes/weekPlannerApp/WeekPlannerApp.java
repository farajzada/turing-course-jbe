package turing_quizzes.lesson_quizzes.weekPlannerApp;

import java.util.Scanner;

public class WeekPlannerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do homework";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "attend team meeting; grocery shopping";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "work on project; gym session";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "write a blog post; practice coding";
        schedule[5][0] = "Friday";
        schedule[5][1] = "finish weekly report; relax with friends";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "do laundry; plan next week";

        while (true) {
            System.out.println("Please, input the day of the week (or 'exit' to quit): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }


            if (input.startsWith("change ") || input.startsWith("reschedule ")) {
                String day = input.split(" ", 2)[1].trim();
                int dayIndex = getDayIndex(day, schedule);
                if (dayIndex != -1) {
                    System.out.println("Please, input new tasks for " + schedule[dayIndex][0] + ":");
                    String newTasks = scanner.nextLine();
                    schedule[dayIndex][1] = newTasks;
                    System.out.println("Tasks for " + schedule[dayIndex][0] + " updated successfully.");
                } else {
                    System.out.println("Sorry, I don't understand you, please try again.");
                }
                continue;
            }


            int dayIndex = getDayIndex(input, schedule);
            if (dayIndex != -1) {
                System.out.println("Your tasks for " + schedule[dayIndex][0] + ": " + schedule[dayIndex][1]);
            } else {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

        scanner.close();
    }


    private static int getDayIndex(String input, String[][] schedule) {
        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0].equalsIgnoreCase(input)) {
                return i;
            }
        }
        return -1;
    }
}

