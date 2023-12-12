package day05.Sort.InsertSort;

public class InsertSortEx {
    public void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer tmp = arr[i];
            Integer j = i - 1;
            while (j >= 0 && tmp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = tmp;
        }

        System.out.print("삽입 정렬 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
