package day05.Sort.QuickSort;

public class LeftQuickSort {
    int quickCount = 0;
    int count = 0;

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low >= high) {      // 왼쪽 값이 오른쪽 값보다 크거나 같다면 서로 겹치는 부분이기 때문에 return
            return;
        }

        int pivot = partition(arr, low, high);      // 피벗을 기준으로 부분 리스트를 나눠준다.

        quickSort(arr, low, pivot - 1);     // 피벗을 기준으로 왼쪽 값들을 정렬
        quickSort(arr, pivot + 1, high);    // 피벗을 기준으로 오른쪽 값들을 정렬
    }

    private int partition(int[] arr, int left, int right) {
        int low = left;             // 가장 왼쪽의 위치
        int high = right;           // 가장 오른쪽의 위치
        int pivot = arr[left];      // 왼쪽 기준이기 때문에 배열의 왼쪽 인덱스 값을 피벗으로 설정

        while (low < high) {        // 위치 이동
            while (arr[high] > pivot) {     // 피벗을 기준으로 오른쪽에 위치한 값이 클 경우
                --high;     // 오른쪽 위치를 감소
            }
            while (arr[low] <= pivot && low < high) {   // 피벗을 기준으로 왼쪽에 위치한 값이 작은 경우
                ++low;      // 왼쪽 위치를 증가
            }
            swap(arr, low, high);       // 피벗을 기준으로 왼쪽의 값은 피벗보다 크고 오른쪽의 값은 피벗보다 작기 때문에 스왑 진행
        }
        swap(arr, left, low);           // 왼쪽의 위치와 오른쪽의 위치가 같기 때문에 스왑을 진행
        return low;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        count++;
//        System.out.printf("%d회차: ", count);
//        for (int k = 0; k < arr.length; k++) {
//            System.out.print(arr[k] + " ");
//        }
//        System.out.println();
        quickCount++;
    }

    public void quickSortPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.printf("총 횟수 = %d\n", quickCount);
    }
}
