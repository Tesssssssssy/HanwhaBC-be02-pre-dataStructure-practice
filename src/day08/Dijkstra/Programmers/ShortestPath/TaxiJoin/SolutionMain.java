package day08.Dijkstra.Programmers.ShortestPath.TaxiJoin;

/**
 *  https://school.programmers.co.kr/learn/courses/30/lessons/72413
 *  프로그래머스 최단 거리 문제 [택시 합승]
 */

public class SolutionMain {
    public static void main(String[] args) {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        Solution solution = new Solution();
        int answer = solution.solution(n, s, a, b, fares);
        System.out.println(answer);
        // 82
    }
}
