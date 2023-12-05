package day01.recursion;

public class FactorialMain {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println("반복문을 이용한 Factorial");
        System.out.println(factorial.recurOperation(5));
        System.out.println();
        System.out.println("재귀를 이용한 Factorial");
        System.out.println(factorial.recurOperation2(5));

        System.out.println();
        System.out.println(factorial.func1(4) + factorial.func1(9));

        System.out.println();

        char[] list = {'a', 'b', 'c'};
        factorial.func2(list, 0, 2);

    }
}
