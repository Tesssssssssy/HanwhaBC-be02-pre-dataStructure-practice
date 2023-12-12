package day05.Sort.HeapSort;

import java.util.Arrays;

public class Heap {                                         // 작성된 코드는 좋은 코드는 아님
    public int[] heapSort(int[] arr) {                       // 오름차순 정렬, 최소힙으로 작성된 코드
        int[] resultArr = new int[arr.length];              // 정렬된 배열을 넣을 새로운 배열 선언
        int arrayLength = arr.length;                       // 배열의 크기를 넣을 변수 생성 및 초기화

        for (int i = 0; i < arrayLength; i = i + 1) {
            // for문이 1번 동작하면 하나의 배열추출 따라서 배열의 크기만큼 동작하도록 하는 for문
            for (int j = (arr.length / 2) - 1; j >= 0; j = j - 1) {     // 힙트리 조건을 만족시키게 바꿔주는 for문
                //힙트리를 위해 삼각형을 만들어주기 위한 횟수는 (배열의 크기/2) 번만 하면됨. 직접 그려보면 (크기/2) 보다 큰 인덱스는 자식이 없다는 것을 알 수 있음
                // arr.length/2 -1      >>  -1을 해준것은 n번째 숫자는 배열에서 n-1번째 인덱스에 있기 때문
                arr = heapify(arr, j);
            }
            swap(arr, 0, arr.length - 1);

            resultArr[i] = arr[arr.length - 1];
            System.out.println("중간 정렬 된 배열 :" + Arrays.toString(arr));
            arr = newArr(arr);
        }
        return resultArr;
    }

    public int[] heapify(int[] arr, int idx) {      // 힙트리를 만족하게 하는 삼각형을 수행하는 메소드
        int tmp;
        if (idx > ((arr.length) / 2) - 1) {         // 재귀에서 idx가 배열의 절반보다 크다면 빠져나감
            return arr;
        }

        if (2 * idx + 2 >= arr.length) {            // idx의 자식 노드가 배열의 크기보다 큰지 확인
            if (arr[idx] > arr[2 * idx + 1]) {      // 부모 노드가 왼쪽 자식보다 크면 교환
                swap(arr, idx, 2 * idx + 1);
                //arr = heapify(arr, 2 * idx + 1);     필요없는 코드
            }
        } else {
            if ((arr[idx] > arr[2 * idx + 1]) || (arr[idx] > arr[2 * idx + 2])) {
                if (arr[2 * idx + 1] >= arr[2 * idx + 2]) {
                    swap(arr, idx, 2 * idx + 2);
                    arr = heapify(arr, 2 * idx + 2);
                } else {
                    swap(arr, idx, 2 * idx + 1);
                    arr = heapify(arr, 2 * idx + 1);
                }
            }
        }
        return arr;
    }

    public int[] swap(int[] arr, int idx1, int idx2) {          // 두 인덱스의 값을 바꿔주는 메소드
        int tmp;
        tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;

        return arr;
    }

    public int[] newArr(int[] arr) {        // 최솟값을 제거하고 새로운 배열을 만드는 메소드
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
}
