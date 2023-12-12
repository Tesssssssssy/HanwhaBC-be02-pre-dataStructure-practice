package day07.Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DfsMyVerMain {
    public static void main(String[] args) {
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

        DfsMyVer dfsMyVer = new DfsMyVer();
        System.out.print("DFS my ver (with recursion): ");
        dfsMyVer.DFS(lists, 1);
        System.out.println();

        System.out.print("DFS my ver (with recursion): ");
        dfsMyVer.DFS(lists, 0);
    }
    /*
        DFS my ver (with recursion): 1 0 3 2 4

        DFS my ver (with recursion): 0 1 2 3 4
    */
}
