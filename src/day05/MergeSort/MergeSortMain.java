package day05.MergeSort;

import static day05.MergeSort.MergeSort.mergeSort;
import static day05.MergeSort.MergeSort.printArray;

public class MergeSortMain {
    public static void main(String[] args) {
        int[] arr = {8, 2, 6, 4, 7, 9, 3, 5};

        System.out.println("처음 배열");
        printArray(arr);

        mergeSort(arr);


    }
}
