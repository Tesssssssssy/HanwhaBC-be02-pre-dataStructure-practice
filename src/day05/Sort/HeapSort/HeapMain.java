package day05.Sort.HeapSort;

import java.util.Arrays;

public class HeapMain {
    public static void main(String[] args) {
        Heap hs = new Heap();

        int[] arr = {13, 49, 5, 87, 12, 39, 8, 43, 7, 28, 58};
        int[] newArr;

        System.out.println("입력된 배열 : " + Arrays.toString(arr));
        newArr = hs.heapSort(arr);
        System.out.println("정렬된 배열 : " + Arrays.toString(newArr));

    /*
            입력된 배열 : [13, 49, 5, 87, 12, 39, 8, 43, 7, 28, 58]
            중간 정렬 된 배열 :[58, 7, 8, 43, 12, 39, 13, 49, 87, 28, 5]
            중간 정렬 된 배열 :[58, 12, 8, 43, 28, 39, 13, 49, 87, 7]
            중간 정렬 된 배열 :[87, 12, 13, 43, 28, 39, 58, 49, 8]
            중간 정렬 된 배열 :[49, 28, 13, 43, 87, 39, 58, 12]
            중간 정렬 된 배열 :[58, 28, 39, 43, 87, 49, 13]
            중간 정렬 된 배열 :[49, 43, 39, 58, 87, 28]
            중간 정렬 된 배열 :[87, 43, 49, 58, 39]
            중간 정렬 된 배열 :[87, 58, 49, 43]
            중간 정렬 된 배열 :[87, 58, 49]
            중간 정렬 된 배열 :[87, 58]
            중간 정렬 된 배열 :[87]
            정렬된 배열 : [5, 7, 8, 12, 13, 28, 39, 43, 49, 58, 87]
    */

        Integer[] arr2 = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int)(Math.random()*100) + 1;
            arr2[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        HeapSortEx heapSortEx = new HeapSortEx();
        heapSortEx.heapSort(arr2.clone());
    }
}
