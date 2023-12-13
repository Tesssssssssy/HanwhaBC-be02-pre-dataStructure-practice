package day08.KakaoEmoji;

import java.util.Arrays;

public class SolutionMain {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] result = solution.solution(users, emoticons);

        System.out.println(Arrays.toString(result));
    }

    /*
        [4, 13860]
    */
}
