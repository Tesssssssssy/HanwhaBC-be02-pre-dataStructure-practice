package day05.Sort.QuickSort;

public class QuickSortEx {
    public void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
        System.out.print("퀵 정렬 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    private void quickSort(Integer[] arr, int left, int right) {
        int part = partition(arr, left, right);
        if (left < part - 1) {
            quickSort(arr, left, part - 1);
        }
        if (part < right) {
            quickSort(arr, part, right);
        }
    }
    private int partition(Integer[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
        return left;
    }
}
