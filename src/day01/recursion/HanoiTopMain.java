package day01.recursion;

import java.util.Scanner;


public class HanoiTopMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("원반의 수를 입력: ");
        int num = scanner.nextInt();
        HanoiTop hanoiTop = new HanoiTop();
        int res = hanoiTop.hanoiMove(num, 1, 2, 3);
        System.out.println("원반의 총 이동 횟수: " + res);
    }
}
