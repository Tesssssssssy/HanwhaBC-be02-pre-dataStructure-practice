package day01.recursion;

/**
 *  - 3개의 기둥이 있고 원반을 옮길 때 작은 원반이 항상 큰 원반 위에 오게 옮기는 방법
 * - 원반은 하나씩만 옮길 수 있다.
 * - 원반의 수를 입력 받고 모든 원반을 다른 기둥으로 옮길 때
 *
 *     몇 개의 이동이 발생하는 지 반환하시오.
 *
 * - 기둥 번호: 1~3번
 *     원반은 가장 작은 원반이 1, 큰 원반일 수록 숫자 +1
 *
 *     k개의 기둥을 k-1, k-2, ..., 1개로 줄여라.
 */

public class HanoiTop {
    private int cnt = 0;

    public int hanoiMove(int num, int from, int temp, int to) {
        cnt++;

        if (num == 1) {
            System.out.println("원반 " + num + " 3출발: " + from + " -> " + "도착: " + to);
        } else if (num > 1) {
            hanoiMove(num - 1, from, to, temp);
            System.out.println("원반 " + num + " 출발: " + from + " -> " + "도착: " + to);
            hanoiMove(num - 1, temp, from, to);
        }
        return cnt;
    }
}
