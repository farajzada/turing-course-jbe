package turing_quizzes.leetcode_problems.longestCommonPrefix;

public class LongestCommonPrefix {
    /**
     * 0ms 100%
     * <a href="https://leetcode.com/problems/longest-common-prefix/description/"> Longest Common Prefix</a>
     **/
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return ""; // check arr empty
        String prefix = strs[0]; // initial prf created
        for (int i = 1; i < strs.length; i++) { // check  prf other strings
            while (strs[i].indexOf(prefix) != 0) { // check prf match main string
                prefix = prefix.substring(0, prefix.length() - 1);

            }
        }
        return prefix;
    }

    public static void main(String[] args) {

        String[] a1 = {"flower", "flow", "flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(a1));
        String[] a3 = {"dog", "racecar", "car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(a3));

    }
}
