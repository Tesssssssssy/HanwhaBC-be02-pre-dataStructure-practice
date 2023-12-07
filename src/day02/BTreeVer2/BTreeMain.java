package day02.BTreeVer2;

import java.util.Scanner;

public class BTreeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i, n, t;
        System.out.print("트리에 넣을 숫자 개수: ");
        n = scanner.nextInt();
        for (i = 0; i < n; i++) {
            System.out.print("입력값: ");
            t = scanner.nextInt();
            BTree.insert(t);
        }
        System.out.println("트리 순회 중...");
        BTree.traverse();
    }
}
