package day05.Sort.QuickSort;

public class QuickSortMain {
    public static void main(String[] args) {
        LeftQuickSort quickSort = new LeftQuickSort();
        MiddleQuickSort middleQuickSort = new MiddleQuickSort();

        int[] arr = { 90, 80, 70, 60, 50, 40, 30, 20, 10,  5 };
        int[] arr1 = { 90, 80, 70, 60, 50, 40, 30, 20, 10, 5 };
        int[] arr2 = { 90, 80, 70, 60, 50, 40, 30, 20, 10, 5 };


        System.out.println("=======================퀵 정렬(가운데 피벗 설정)=================");
        middleQuickSort.sort(arr);                                                                      //
        middleQuickSort.sortPrint(arr);

        System.out.println();

        System.out.println("=======================퀵 정렬(왼쪽 피벗 설정)===================");
        quickSort.sort(arr1);
        quickSort.quickSortPrint(arr1);

        System.out.println();

        System.out.println("=======================버블 정렬===============================");
        middleQuickSort.basicSort(arr2);
        middleQuickSort.basicSortPrint(arr2);

        Integer[] arr5 = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int)(Math.random()*100) + 1;
            arr5[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        QuickSortEx quickSortEx = new QuickSortEx();
        quickSortEx.sort(arr5.clone());
    }
    /*
            =======================퀵 정렬(가운데 피벗 설정)=================
            1회차: 5 80 70 60 50 40 30 20 10 90
            2회차: 5 10 70 60 50 40 30 20 80 90
            3회차: 5 10 20 60 50 40 30 70 80 90
            4회차: 5 10 20 30 50 40 60 70 80 90
            5회차: 5 10 20 30 40 50 60 70 80 90
            5 10 20 30 40 50 60 70 80 90
            총 횟수 = 5
            =======================퀵 정렬(왼쪽 피벗 설정)===================
            5 10 20 30 40 50 60 70 80 90
            총 횟수 = 18

            =======================버블 정렬===============================
            5 10 20 30 40 50 60 70 80 90
            총 횟수 = 45
    */
}
