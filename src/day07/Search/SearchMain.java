package day07.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  그래프는 0번 인덱스에 몇 번 노드오 연결되어 있다고 표현하던가
 *  2차원 배열로 몇 번 노드와 몇 번 노드가 연결되어 있으면 1로 표시하던가
 *  map을 사용하면 <0, [1, 3, 4]> 이런식으로 해도 된다.
 *  본인이 편한 마음대로.
 */

public class SearchMain {
    public static void main(String[] args) {
    /*
        그래프를 2차원 리스트로 구현해보자.
        [
          [1, 3, 4],
          [0, 2],
          [1, 3],
          [0, 2, 4],
          [0, 3]
                     ]
    */

        List<Integer> list0 = Arrays.asList(1, 3, 4);
        List<Integer> list1 = Arrays.asList(0, 2);
        List<Integer> list2 = Arrays.asList(1, 3);
        List<Integer> list3 = Arrays.asList(0, 2, 4);
        List<Integer> list4 = Arrays.asList(0, 3);

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        Dfs dfs = new Dfs();
        Bfs bfs = new Bfs();

        dfs.search(lists, 1);
        dfs.searchRecursive(lists, 1);
        /*
            깊이 우선 탐색: 1 0 3 2 4

            깊이 우선 탐색 : 1 0 3 2 4 재귀 방식
        */
        /*
            dfs.search(lists, 0);

            깊이 우선 탐색: 0 1 2 3 4
        */

        bfs.search(lists, 1);

        /*
            너비 우선 탐색 : 1 2 0 3 4
        */
        /*
            bfs.search(lists, 0);

            너비 우선 탐색 : 0 4 3 1 2
        */
    }
}
