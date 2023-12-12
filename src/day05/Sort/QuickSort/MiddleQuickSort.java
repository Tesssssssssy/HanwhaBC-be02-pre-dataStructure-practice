package day05.Sort.QuickSort;

public class MiddleQuickSort {

    int quickCount = 0;     // 퀵 정렬 횟수
    int basicCount = 0;     // 버블 정렬 횟수

    public void sort(int[] arr) {                                                                           //
        // 퀵 정렬 메서드 실행
        // 퀵 정렬 메서드 매개변수로 인덱스가 0부터 시작해서 high 값은 길이에서 -1을 한 값을 전달
        quickSort(arr, 0, arr.length - 1);                                                        //
    }

    private void quickSort(int[] arr, int low, int high) {                                                  //
        // low와 high값이 만나거나 교차되었을 경우
        if (low >= high) {
            return;
        }
        else {
            // 피벗 변수에 partition 메서드의 반환값(int)를 저장한다.
            // partition 메서드에서 반환되는 high 값을 새로운 피벗으로 설정한다.
            int pivot = partition(arr, low, high);                                                              //

            // 새로운 피벗을 기준으로 부분 리스트를 나눠서 다시 퀵 정렬을 진행한다.
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int left, int right) {                                                 //
        int low = left;                         // 인덱스의 범위를 지정해주기 위해서 왼쪽을 저장한다.
        int high = right;                       // 인덱스의 범위를 지정해주기 위해서 오른쪽을 저장한다.
        int pivot = arr[(left + right) / 2];    // 피벗 값으로 가운데 값을 저장한다.

        // 무한 반복
        while (true) {
            // low를 늘리면서 low번째 배열요소가 pivot보다 큰 경우를 찾는 과정
            while (arr[low] < pivot) {  // 왼쪽에 위치한 값이 피벗 값보다 커질 때까지 반복한다.
                ++low;      // 왼쪽 위치를 오른쪽으로 한 칸 이동시킨다.
            }
            // high를 줄이면서 high번째 배열요소가 pivot보다 작은 경우를 찾는 과정
            while (arr[high] > pivot && low <= high) {  // low위치가 high 위치보다 작거나 같으면 교차를 시켜야 되서 high 값을 빼줘야 함
                --high;     // 오른쪽 위치를 왼쪽으로 한 칸 이동시킨다.
            }

            // low가 high보다 크거나 같을 때
            if (low >= high) {  // low와 high가 만나거나 교차했을 경우
                return high;    // high 값을 반환
            }

            // low 위치의 값과 high 위치의 값을 바꿔준다.
            else {  swap(arr, low, high);
            }                                                                           //
        }
    }

    private void swap(int[] arr, int i, int j) {                                                            //
        // i = low
        // j = high

        int temp = arr[i];  // i(low)에 위치한 값을 temp 변수에 저장
        arr[i] = arr[j];    // j(high)에 위치한 값을 i번째 위치에 저장
        arr[j] = temp;      // j번째 위치에 temp 변수에 저장된 값을 저장

        // 출력
        quickCount++;
        System.out.printf("%d회차: ", quickCount);
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    public void sortPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.printf("총 횟수 = " + quickCount);
    }

    public void basicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    basicCount++;
                }
            }
        }
    }

    public void basicSortPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.printf("총 횟수 = " + basicCount);
    }
}
