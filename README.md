# Prime Factorization of a Number in Exponential Form

This project demonstrates the implementation of prime factorization (in exponential form), prime divisors & divisors of a number.

Methods:  

`PrimeFactorization.primeFactorization(int n)`: Returns the prime factorization of `n` in exponential form as `String`.  

`PrimeFactorization.primeDivisors(int n)`: Returns the prime divisors of `n` as `int[]`.  

`PrimeFactorization.divisors(int n)`: Returns the divisors of `n` as `int[]`.

### Prime Factorization

```java
String x = PrimeFactorization.primeFactorization(180);
System.out.println(x); // 2^2 * 3^2 * 5^1
```

### Prime Divisors

```java
int[] y = PrimeFactorization.primeDivisors(180);

for (int i = 0; i < y.length; i++) {
   System.out.println(y[i]);
} // 2 3 5
```

### Divisors

```java
int[] z = PrimeFactorization.divisors(180);

for (int i = 0; i < z.length; i++) {
   System.out.print(z[i] + " ");
} // 1 2 3 4 5 6 9 10 12 15 18 20 30 36 45 60 90 180
```
