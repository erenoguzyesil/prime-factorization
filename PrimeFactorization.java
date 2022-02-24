package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class PrimeFactorization {
    private static ArrayList<Integer> _divisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) { // from `i` (0) to the `n`
            if (n % i == 0) { // if `n` is divisible by `i`
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static int count(ArrayList<Integer> array, int element) { // count the number of occurrences of an element in an arraylist
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
                                                // ^^element, ^^occurrences

        for (int i = 0; i < array.size(); i++) {
            if (map.containsKey(array.get(i))) { // if element already exists in the `map` (more than 1 occurrence)
                map.put(array.get(i), map.get(array.get(i))+ 1);
            } else { // if it does not exist (1 occurrence)
                map.put(array.get(i), 1);
            }
        }

        return map.get(element);
    }

    public static String primeFactorization(int n) {
        int number = n;
        int number2 = number;
        ArrayList<Integer> repeatingDvs = new ArrayList<Integer>(); // prime divisors of a number in repeating form

        for (int i = 1; i <= number2; i++) {
            if (number2 % i == 0 && _divisors(i).size() == 2) { // if `n` is divisible by `i` & `i` is prime (has two divisors)
                int remainder = number2 % i;
                while (remainder == 0) { // while `n` is divisible by `i`
                    number2 /= i; // divide `n` by `i` again
                    remainder = number2 % i;
                    repeatingDvs.add(i);
                }
            }
        }

        ArrayList<Integer> repeatingDvs2 =  new ArrayList<Integer>(); // `repeatingDvs` but without duplicates

        for (int i = 0; i < repeatingDvs.size(); i++) {
            if (!(repeatingDvs2.contains(repeatingDvs.get(i)))) {
                repeatingDvs2.add(repeatingDvs.get(i));
            }
        }

        String exponentialForm = "";

        for (int i = 0; i < repeatingDvs2.size(); i++) {
            if (i == repeatingDvs2.size() - 1) { // if the last element
                exponentialForm += repeatingDvs2.get(i) + "^" + count(repeatingDvs, repeatingDvs2.get(i)); // count the occurrences of the element
                                                                                                           // in `repeatingDvs` (with duplicates)
            } else {
                exponentialForm += repeatingDvs2.get(i) + "^" + count(repeatingDvs, repeatingDvs2.get(i)) + " * ";
            }
        }

        return exponentialForm;
    }

    public static int[] primeDivisors(int n) {
        ArrayList<Integer> primeDivisors = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (_divisors(i).size() == 2 && n % i == 0) {
                primeDivisors.add(i);
            }
        }

        return primeDivisors.stream().mapToInt(i -> i).toArray(); // convert ArrayList<Integer> to int[]
    }

    public static int[] divisors(int n) {
        return _divisors(n).stream().mapToInt(i -> i).toArray(); // convert ArrayList<Integer> to int[]
    }
}
