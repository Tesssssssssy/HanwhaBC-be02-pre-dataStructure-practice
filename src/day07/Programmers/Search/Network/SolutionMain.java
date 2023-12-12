package day07.Programmers.Search.Network;

public class SolutionMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int[][] computers2 = {{1,1,0}, {1,1,1}, {0,1,1}};

        // 너비 우선 탐색 방식
        int answer = solution.solution(computers.length, computers);
        System.out.println(answer);
        // 2

        int answer2 = solution.solution(computers2.length, computers2);
        System.out.println(answer2);
        // 1

        // 깊이 우선 탐색 + 재귀 방식
        int answer3 = solution2.solution(computers.length, computers);
        System.out.println(answer3);
        // 2

        int answer4 = solution2.solution(computers2.length, computers2);
        System.out.println(answer4);
        // 1
    }
}
