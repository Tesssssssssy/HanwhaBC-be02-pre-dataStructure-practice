package day01.recursion;

public class Euclidean {
    public Integer gcd(Integer a, Integer b) {
        if (b == 0) {
            return a;
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
         /*
            26 mod 15 = 1 * 15 + 11
            15 mod 11 = 1 * 11 + 4
            11 mod  4 = 2 * 4 + 3
             4 mod  3 = 1 * 3 + 1

            a % b의 결과 값이 피연산자 b가 되고
            피연산자 b가 연산자 a가 되어야 한다.

            그래야 재귀로 호출하면서 최대공약수를 찾을 수 있다.
         */
    }
}
