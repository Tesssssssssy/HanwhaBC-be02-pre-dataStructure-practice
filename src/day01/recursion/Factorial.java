package day01.recursion;

public class Factorial {
    // 반복문을 이용한 Factorial
    public Integer recurOperation(Integer num) {
        Integer res = num;
        for (int i = num - 1; i > 0; i--) {
            res *= i;
            System.out.println(num);
        }
        return res;
    }

    // 재귀를 이용한 Factorial
    public Integer recurOperation2(Integer num) {
        if (num > 0) {
            System.out.println(num);
            return num * recurOperation2(num - 1);
        } else {
            return 1;
        }
    }

    // 7급 자료구조 문제 (재귀인 줄 알았지만 아님)
    public int func1(int num) {
        int res = 0;
        if (num <= 1) {
            res = num;
        } else {
            int fn = 0;
            int fnm2 = 0;
            int fnm1 = 1;
            for (int i = 2; i < num; i++) {
              fn = fnm1 + fnm2;
              fnm2 = fnm1;
              fnm1 = fn;
          }
          res = fn;
        }
        return res;
    }

    public void func2(char[] strarr, int i, int n) {
        int j = 0;
        char temp = 0;

        if (i == n) {
            for (j = 0; j <= n; j++) {
                System.out.print(strarr[j]);
            }
            System.out.print(" ");
        } else {
            for (j = i; j <= n; j++) {
                SWAP(strarr[i], strarr[j], temp);
                func2(strarr, i+1, n);
                SWAP(strarr[i], strarr[j], temp);
            }
        }
    }

    public void SWAP(char x, char y, char t) {
        t = x;
        x = y;
        y = t;
    }
}


