package day07.Programmers.Search.TravelPlan;

public class SolutionMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
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

        String[] ans = solution.solution(tickets);
        for (int i = 0; i < ans.length; i++) {
            System.out.print("[\"" + ans[i] + "\"]");
        }
        /*
            ["ICN"]["JFK"]["HND"]["IAD"]
        */

        System.out.println();

        String[] ans2 = solution.solution(tickets2);
        for (int i = 0; i < ans2.length; i++) {
            System.out.print("[\"" + ans2[i] + "\"]");
        }
        /*
            ["ICN"]["ATL"]["ICN"]["SFO"]["ATL"]["SFO"]
        */
    }
}
