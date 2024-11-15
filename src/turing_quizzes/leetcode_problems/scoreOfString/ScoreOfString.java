package turing_quizzes.leetcode_problems.scoreOfString;

public class ScoreOfString {
    public static int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth;
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println("Sətirin skoru: " + scoreOfParentheses(s));
    }
}
