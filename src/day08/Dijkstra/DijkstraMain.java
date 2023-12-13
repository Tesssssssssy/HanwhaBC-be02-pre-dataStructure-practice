package day08.Dijkstra;

/**
 *      [0, 3, 7]   ->   0---(7)---3
 *      [0, 1, 8]   ->   0---(8)---1
 *      [0, 4, 2]   ->   0---(2)---4
 *
 *      [1, 5, 1]   ->   1---(1)---5
 *
 *      [3. 5. 8]   ->   3---(8)---5
 *      [3, 7, 9]   ->   3---(9)---7

 *      [4, 6, 2]   ->   4---(2)---6
 *
 *      [5, 7, 4]   ->   5---(4)---7
 *
 *      [6, 2, 7]   ->   6---(7)---2
 *      [6, 7, 5]   ->   6---(5)---7
 */

public class DijkstraMain {
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 8},{0, 3, 7},{0, 4, 2},{1, 5, 1},{3, 5, 8},{3, 7, 9},{5, 7, 4},{6, 7, 5},{2, 6, 7},{4, 6, 2}};
        // 그래프에는 숫자들이 저장된 배열들이 저장되어 있다.

        DijkstraEx dijkstraEx = new DijkstraEx();

        dijkstraEx.findPath(8, graph);
        dijkstraEx.printPath();
    }

    /*
            costs:
            To node 0: 0
            To node 1: 8
            To node 2: 11
            To node 3: 7
            To node 4: 2
            To node 5: 9
            To node 6: 4
            To node 7: 9
            path:
            To node 0: 0
            To node 1: 0
            To node 2: 6
            To node 3: 0
            To node 4: 0
            To node 5: 1
            To node 6: 4
            To node 7: 6
            0 : 0
            1 : 0
            2 : 6 4 0
            3 : 0
            4 : 0
            5 : 1 0
            6 : 4 0
            7 : 6 4 0
    */
}
