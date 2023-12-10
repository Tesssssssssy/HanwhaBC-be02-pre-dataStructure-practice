package day05.InsertSort;

public class InsertSort {
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int targetValue = arr[i];
            int previousValueIndex = i - 1;

            while (previousValueIndex >= 0 && targetValue < arr[previousValueIndex]) {
                arr[previousValueIndex+1] = arr[previousValueIndex];
                previousValueIndex -= 1;
            }
            arr[previousValueIndex + 1] = targetValue;

            System.out.print(targetValue + " 삽입 -> ");
            printArray(arr);
        }
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
