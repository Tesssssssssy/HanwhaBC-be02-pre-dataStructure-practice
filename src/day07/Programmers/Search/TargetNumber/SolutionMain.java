package day07.Programmers.Search.TargetNumber;

public class SolutionMain {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {4, 1, 2, 1};
        int answer = solution.solution(arr, 4);
        System.out.println(answer);
    }

    /*
        numbers	            target	 return
        [1, 1, 1, 1, 1]	      3	       5
        [4, 1, 2, 1]	      4	       2
    */
}
