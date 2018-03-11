/*
 * Based on: https://articles.leetcode.com/longest-palindromic-substring-part-ii/
 */

public class ManacherPalindrome {

    private static char[] process(String s) {

        char[] altChars = new char[s.length() * 2 + 3];

        altChars[0] = '$';
        altChars[s.length() * 2 + 1] = '#';
        altChars[s.length() * 2 + 2] = '@';

        for (int i = 0; i < s.length(); i++) {

            altChars[i * 2 + 1] = '#';
            altChars[i * 2 + 2] = s.charAt(i);

        }

        return altChars;

    }

    private static int[] runManacher(char[] altChars) {

        int[] palinTable = new int[altChars.length];

        int center = 0, right = 0;

        for (int i = 1; i < altChars.length - 1; i++) {

            int opposite = center * 2 - i;

            if (right > i) {
                palinTable[i] = Math.min(right - i, palinTable[opposite]);
            }

            while (altChars[i + (1 + palinTable[i])] == altChars[i - (1 + palinTable[i])]) {
                palinTable[i]++;
            }

            if (i + palinTable[i] > right) {
                center = i;
                right = i + palinTable[i];
            }

        }

        return palinTable;

    }

    public static String longestPalindrome(String s) {

        char[] altChars = process(s);
        int[] palinTable = runManacher(altChars);

        int longest = 0, center = 0;

        for (int i = 0; i < palinTable.length - 1; i++) {

            if (palinTable[i] > longest) {
                longest = palinTable[i];
                center = i;
            }

        }

        return s.substring((center - 1 - longest) / 2, (center - 1 + longest) / 2);

    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("blahblahblahracecarblah"));

    }

}
