package day07.Programmers.Greedy.AthleticClothes;

public class AthleticClothesMain {
    public static void main(String[] args) {
/*
    n	lost	  reserve	    return
    5	[2, 4]	  [1, 3, 5]	     5
    5	[2, 4]	  [3]	         4
    3	[3]	      [1]	         2
*/
        AthleticClothes athleticClothes = new AthleticClothes();

        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int n = 5;

        int result = athleticClothes.solution(n, lost, reserve);
        System.out.println(result);
        // 5


        AthleticClothesUsingSet athleticClothesUsingSet = new AthleticClothesUsingSet();

        int[] lost2 = {2, 4};
        int[] reserve2 = {1, 3, 5};
        int n2 = 5;

        int result2 = athleticClothesUsingSet.solution(n2, lost2, reserve2);
        System.out.println(result2);
        // 5
    }
}
