package day05.MergeSort;

public class MergeSort {
    private static int[] sorted;

    public static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        sorted = null;
    }

    /*
        메소드에 static을 달면 변수에도 static을 달아주어야 한다.
    */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            System.out.println("배열을 " + left + "부터 " + right + "까지 반으로 나눕니다.");
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            System.out.println("배열을" + left + "부터" + mid + "와 " + right + "를 병합합니다.");
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
