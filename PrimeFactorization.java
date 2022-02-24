package com.company;
import java.util.ArrayList;
import java.util.HashMap;

public class PrimeFactorization {
    private static ArrayList<Integer> _divisors(int n) {
        ArrayList<Integer> divisors = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static int count(ArrayList<Integer> array, int element) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.size(); i++) {
            if (map.containsKey(array.get(i))) {
                map.put(array.get(i), map.get(array.get(i))+ 1);
            } else {
                map.put(array.get(i), 1);
            }
        }

        return map.get(element);
    }

    public static String primeFactorization(int n) {
        int number = n;
        int number2 = number;
        ArrayList<Integer> repeatingDvs = new ArrayList<Integer>();

        for (int i = 1; i <= number2; i++) {
            if (number2 % i == 0 && _divisors(i).size() == 2) {
                int remainder = number2 % i;
                while (remainder == 0) {
                    number2 /= i;
                    remainder = number2 % i;
                    repeatingDvs.add(i);
                }
            }
        }

        ArrayList<Integer> repeatingDvs2 =  new ArrayList<Integer>();

        for (int i = 0; i < repeatingDvs.size(); i++) {
            if (!(repeatingDvs2.contains(repeatingDvs.get(i)))) {
                repeatingDvs2.add(repeatingDvs.get(i));
            }
        }

        String exponentialForm = "";

        for (int i = 0; i < repeatingDvs2.size(); i++) {
            if (i == repeatingDvs2.size() - 1) {
                exponentialForm += repeatingDvs2.get(i) + "^" + count(repeatingDvs, repeatingDvs2.get(i));
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

        return primeDivisors.stream().mapToInt(i -> i).toArray();
    }

    public static int[] divisors(int n) {
        return _divisors(n).stream().mapToInt(i -> i).toArray();
    }
}
