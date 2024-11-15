package turing_quizzes.leetcode_problems.scoreOfString;

public class ScoreOfString {
    public static int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0; // mötərizənin cari dərinliyi

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++; // açıq mötərizə dərinliyi artırır
            } else {
                depth--; // bağlanış mötərizə dərinliyi azaldır
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth; // 2^depth skoru əlavə olunur
                }
            }
        }

        return score;
    }

    public static void main(String[] args) {
        String s = "(()(()))"; // test nümunəsi
        System.out.println("Sətirin skoru: " + scoreOfParentheses(s));
    }
}
