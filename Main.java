// Prime Factorization of a Number in Exponential Form in Java

import java.util.*;

class Main {
  public static ArrayList<Integer> divisors(int n) {
    ArrayList<Integer> divisors = new ArrayList<Integer>();

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        divisors.add(i);
      }
    }

    return divisors;
  }

  public static int count(ArrayList<Integer> array, int element) {
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

  public static void main(String[] args) {
    System.out.print("Enter a number: ");
    Scanner s = new Scanner(System.in);
    int number = s.nextInt();
    s.close();
    int number2 = number;
    ArrayList<Integer> repeatingDvs = new ArrayList<Integer>();

    for (int i = 1; i <= number2; i++) {
      if (number2 % i == 0 && divisors(i).size() == 2) {
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

    System.out.println(exponentialForm);
  }
}
