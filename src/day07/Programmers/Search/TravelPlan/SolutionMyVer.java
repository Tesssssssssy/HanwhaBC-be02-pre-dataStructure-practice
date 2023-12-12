package day07.Programmers.Search.TravelPlan;

import java.util.*;

public class SolutionMyVer {
    public static void main(String[] args) {
        String[][] tickets = {
                {"ICN", "JFK"},
                {"HND", "IAD"},
                {"JFK", "HND"}
        };

        String[][] tickets2 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        };

//        for (int i = 0; i < tickets.length; i++) {
//            for (int j = 0; j < tickets[0].length; j++) {
//                System.out.print(tickets[i][j] + " ");
//            }
//            System.out.println();
//        }

        String[] answer = solution(tickets);
        System.out.println(answer);

//        String[] answer2 = solution(tickets2);
//        System.out.println(answer2);
    }

    public void search(String[][] lists, boolean[] visited) {
        Queue<String> queue = new LinkedList<>();

        List<String> strList = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            for (int j = 0; j < lists[0].length; j++) {
                strList.add(lists[i][j].toString());
            }
            System.out.println();
        }

        for (String arr : strList) {
            System.out.println(arr);
        }

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i].length != 0) {
                if (!map.containsKey(lists[i][0])) {
                    map.put(lists[i][0], lists[i][1]);
                }
            }
        }

        Collection<String> values = map.values();
        System.out.println(values);
    }





    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        boolean[] visited = new boolean[tickets.length];



        return answer;
    }
}
