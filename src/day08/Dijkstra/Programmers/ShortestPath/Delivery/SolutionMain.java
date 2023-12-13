package day08.Dijkstra.Programmers.ShortestPath.Delivery;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/12978
 *  프로그래머스 최단 거리 문제 [배달]
 */

public class SolutionMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int N = 5;
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        int K = 3;

        int N2 = 6;
        int[][] road2 = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
        int K2 = 4;

        int ans = solution.solution(N, road, K);
        System.out.println(ans);
        // 4 (정답)

        int ans2 = solution.solution(N2, road2, K2);
        System.out.println(ans2);
        // 4 (정답)
    }
}
