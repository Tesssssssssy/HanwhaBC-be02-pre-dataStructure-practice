package day05.Sort.ShellSort;

public class ShellSortMain {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        int[] arr = {8, 3, 2, 1, 5, 4, 10};
        System.out.print("Shell Sort 전 배열: ");
        for (int ar : arr) {
            System.out.print("["+ar+"]");
        }
        System.out.println("\n");

        int[] sortedArray = shellSort.shellSort(arr.clone());

        System.out.print("Shell Sort 후 배열: ");
        for (int soAr : sortedArray) {
            System.out.print("[" + soAr + "]");
        }

        Integer[] arr4 = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int)(Math.random()*100) + 1;
            arr4[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        ShellSortEx shellSortEx = new ShellSortEx();
        shellSortEx.sort(arr4.clone());


    }

    /*
        Shell Sort 전 배열: [8][3][2][1][5][4][10]

        Shell Sort 후 배열: [1][2][3][4][5][8][10]
    */
}
