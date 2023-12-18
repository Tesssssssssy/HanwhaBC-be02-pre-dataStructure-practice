package day05.Sort.BubbleSort;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        // 배열의 size - 1회차 만큼 반복
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                // 왼쪽 원소가 오른쪽 원소보다 크면 바꿔치기
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }

            // 한 회전이 끝날 때마다 전체 배열 출력
            System.out.print(i + 1 + "회전: [ ");
            for (int x = 0; x < arr.length; x++) {
                System.out.print(arr[x] + " ");
            }
            System.out.println("]");
        }

        // 최종 배열 출력
        System.out.print("최종 배열 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
