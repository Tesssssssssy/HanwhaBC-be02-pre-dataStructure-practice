package day05.Sort.MergeSort;

public class MergeSortMain {
    // Driver code
    public static void main(String args[])    {
        TopDownMerge topDown = new TopDownMerge();
        int arr[] = { 11, 12, 5, 13, 7, 6, 24, 19, 2, 29};

        System.out.print("정렬할 배열 : ");
        topDown.printArray(arr);

        topDown.mergeSort(arr);

//        int arr2[] = { 11, 12, 5, 13, 7, 6, 24, 19};
//
//        topDown.mergeSort(arr2);
//        int arr3[] = { 11, 12, 5, 13, 7, 6, 24, 19, 2, 29, 44, 78};
//        topDown.mergeSort(arr3);

//        BottomUpMerge bottomUp = new BottomUpMerge();
//        bottomUp.printArray(arr);
//        bottomUp.merge_sort(arr);

        Integer[] arr2 = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int)(Math.random()*100) + 1;
            arr2[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        MergeSortEx mergeSortEx = new MergeSortEx();
        mergeSortEx.sort(arr2.clone());
    }

    /*
            정렬할 배열 : 11 12 5 13 7 6 24 19 2 29
            배열 시작 번호 : 0, 배열 중간 번호 : 0, 배열 끝 번호 : 1
            작은 수 : 11 0 0 0 0 0 0 0 0 0
            나머지 : 11 12 0 0 0 0 0 0 0 0
            현재 배열 : 11 12 5 13 7 6 24 19 2 29
            ---------------------------------------
            배열 시작 번호 : 0, 배열 중간 번호 : 1, 배열 끝 번호 : 2
            작은 수 : 5 12 0 0 0 0 0 0 0 0
            나머지 : 5 11 12 0 0 0 0 0 0 0
            현재 배열 : 5 11 12 13 7 6 24 19 2 29
            ---------------------------------------
            배열 시작 번호 : 3, 배열 중간 번호 : 3, 배열 끝 번호 : 4
            작은 수 : 5 11 12 7 0 0 0 0 0 0
            나머지 : 5 11 12 7 13 0 0 0 0 0
            현재 배열 : 5 11 12 7 13 6 24 19 2 29
            ---------------------------------------
            배열 시작 번호 : 0, 배열 중간 번호 : 2, 배열 끝 번호 : 4
            작은 수 : 5 7 11 12 13 0 0 0 0 0
            나머지 : 5 7 11 12 13 0 0 0 0 0
            현재 배열 : 5 7 11 12 13 6 24 19 2 29
            ---------------------------------------
            배열 시작 번호 : 5, 배열 중간 번호 : 5, 배열 끝 번호 : 6
            작은 수 : 5 7 11 12 13 6 0 0 0 0
            나머지 : 5 7 11 12 13 6 24 0 0 0
            현재 배열 : 5 7 11 12 13 6 24 19 2 29
            ---------------------------------------
            배열 시작 번호 : 5, 배열 중간 번호 : 6, 배열 끝 번호 : 7
            작은 수 : 5 7 11 12 13 6 19 0 0 0
            나머지 : 5 7 11 12 13 6 19 24 0 0
            현재 배열 : 5 7 11 12 13 6 19 24 2 29
            ---------------------------------------
            배열 시작 번호 : 8, 배열 중간 번호 : 8, 배열 끝 번호 : 9
            작은 수 : 5 7 11 12 13 6 19 24 2 0
            나머지 : 5 7 11 12 13 6 19 24 2 29
            현재 배열 : 5 7 11 12 13 6 19 24 2 29
            ---------------------------------------
            배열 시작 번호 : 5, 배열 중간 번호 : 7, 배열 끝 번호 : 9
            작은 수 : 5 7 11 12 13 2 6 19 24 29
            나머지 : 5 7 11 12 13 2 6 19 24 29
            현재 배열 : 5 7 11 12 13 2 6 19 24 29
            ---------------------------------------
            배열 시작 번호 : 0, 배열 중간 번호 : 4, 배열 끝 번호 : 9
            작은 수 : 2 5 6 7 11 12 13 19 24 29
            나머지 : 2 5 6 7 11 12 13 19 24 29
            현재 배열 : 2 5 6 7 11 12 13 19 24 29
            ---------------------------------------

    */
}
