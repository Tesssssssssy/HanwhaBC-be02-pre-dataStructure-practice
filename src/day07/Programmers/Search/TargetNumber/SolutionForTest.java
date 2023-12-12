package day07.Programmers.Search.TargetNumber;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  프로그래머스 깊이/너비 우선 탐색 문제 - 타켓 넘버
 *  IntelliJ에서 실행해보기 위한 용도의 클래스
 */

class SolutionForTest {
    public static void main(String[] args) {
        solution();
    }
    public static int solution() {
        int answer = 0;

        int[] numbers = {4, 1, 2, 1};
        int targetNum = 4;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        for (int i = 0; i < numbers.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer sum = queue.poll();
                queue.add(sum + numbers[i]);
                queue.add(sum - numbers[i]);
            }
        }

        while (!queue.isEmpty()) {
            Integer sum = queue.poll();

            if (sum == targetNum) {
                answer += 1;
            }
        }

        System.out.println(answer);

        /*
        Integer sum = queue.poll();
        queue.add(sum + numbers[1]);
        queue.add(sum - numbers[1]);

        sum = queue.poll();
        queue.add(sum + numbers[2]);
        queue.add(sum - numbers[2]);

        sum = queue.poll();
        queue.add(sum + numbers[2]);
        queue.add(sum - numbers[2]);

        sum = queue.poll();
        queue.add(sum + numbers[3]);
        queue.add(sum - numbers[3]);

        sum = queue.poll();
        queue.add(sum + numbers[3]);
        queue.add(sum - numbers[3]);

        sum = queue.poll();
        queue.add(sum + numbers[3]);
        queue.add(sum - numbers[3]);

        sum = queue.poll();
        queue.add(sum + numbers[3]);
        queue.add(sum - numbers[3]);

        int[] numbers = {4, 1, 2, 1} 이므로
        처음에 0으로 시작해야 루트 노드부터 -,+로 나누지 않으므로
        add(0)을 통해 초기값 0 삽입

                                    0
                           /               \
        (0 - numbers[1]) -4                 +4 (0 + numbers[1])
                      /      \           /       \
                    -4-1=-5  -4+1=-3   +4-1=3   +4+1=5

                    ... 반복

        */
        return answer;
    }
}