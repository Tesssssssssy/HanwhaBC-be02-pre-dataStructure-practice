package day01.recursion;

public class EuclideanMain {
    public static void main(String[] args) {
        Euclidean euc = new Euclidean();

        System.out.println(euc.gcd(22, 8));
        // 2

        /*
            22 mod 8 = 2 * 8 + 6;
            8 mod 6 = 1 * 6 + 2;
            6 mod 2 = 3 * 2 + 0;
        */

        System.out.println(euc.gcd(14, 7));
        System.out.println(euc.gcd(15,3));
        System.out.println(euc.gcd(26, 15));
        /*
            26 mod 15 = 1 * 15 + 11
            15 mod 11 = 1 * 11 + 4
            11 mod  4 = 2 * 4 + 3
             4 mod  3 = 1 * 3 + 1
         ----------------------------
             3 mod  1 = 1 * 3 + 0
             -> 나머지가 0이 되는 수는 1 밖에 없으므로
                26과 15의 최대공약수는 1 밖에 없다.
        */


        /*
             2
             7
             3
             1
        */
    }
}
