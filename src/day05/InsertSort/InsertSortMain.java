package day05.InsertSort;

public class InsertSortMain {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();

        int[] arr = new int[]{5, 4, 1, 3, 2};

        insertSort.insertionSort(arr);

        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " " );
        }
    }

}
