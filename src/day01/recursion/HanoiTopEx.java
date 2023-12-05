package day01.recursion;

public class HanoiTopEx {
    public void move (Integer num, Integer from, Integer to) {
        // n-1을 from에서 from도 to도 아닌 곳으로 이동
        if (num > 1) {
            move(num - 1, from, 6 - from - to);
        }
        System.out.println("원반 " + num + "를 " + from + "번 기둥에서 " + to + "번 기둥으로 이동했다.");

        if (num > 1) {
            move(num - 1, 6 - from - to, to);
        }
    }
}
