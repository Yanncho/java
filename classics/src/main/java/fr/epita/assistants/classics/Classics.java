package fr.epita.assistants.classics;

import org.apache.commons.lang3.ObjectUtils;

public class Classics {
    /**
     * Computes the factorial of n.
     *
     * @param n the nth value to compute, negative values should return -1
     * @return the long value of n!
     */
    public static long factorial(int n) {
        if (n < 0)
            return -1;
        long res = 1;
        while (n > 1) {
            res *= n;
            n--;
        }
        return res;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        long t0 = 0;
        long t1 = 1;
        long t2 = 1;
        while (n > 2) {
            long tmp = t2;
            t2 += t1 + t0;
            t0 = t1;
            t1 = tmp;
            n--;
        }
        return t2;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        if (word == null)
            return false;
        int acc = 0;
        while (acc < word.length() / 2) {
            if (word.charAt(acc) == ' ' || word.charAt(word.length() - 1 - acc) == ' ') {
                acc++;
                continue;
            }
            if (Character.toUpperCase(word.charAt(acc)) != Character.toUpperCase(word.charAt(word.length() - 1 - acc)))
                return false;
            acc++;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     */
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        String res = new String();
        int acc1 = 0;
        int acc2 = 0;
        while (acc1 < a.length() && acc2 < b.length()) {
            res += a.charAt(acc1);
            res += b.charAt(acc2);
            acc2++;
            acc1++;
        }
        if (acc1 < a.length())
            res += a.substring(acc1, a.length());
        else if (acc2 < b.length()) {
            res += b.substring(acc2, b.length());
        }
        return res;
    }
}
