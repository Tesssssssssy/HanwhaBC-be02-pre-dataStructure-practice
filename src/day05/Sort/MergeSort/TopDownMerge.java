package day05.Sort.MergeSort;

public class TopDownMerge {
    // 합치는 과정에서 정렬하여 원소를 담을 임시배열
    private int[] sorted;

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public void mergeSort(int[] a) {
        sorted = new int[a.length];
        mergeSort(a, 0, a.length - 1);
    }

    // Top-Down 방식 구현
    public void mergeSort(int[] a, int left, int right) {
        // left == right 즉, 부분리스트가 1개의 원소만 갖고있는 경우
        // 더이상 쪼갤 수 없으므로 return 한다.
        if (left == right)
            return;

        // 절반 위치
        int mid = (left + right) / 2;
        // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort(a, left, mid);
        // 절반 중 오른쪽 부분리스트(mid+1 ~ right)
        mergeSort(a, mid + 1, right);
        // 병합작업
        merge(a, left, mid, right);
    }

    // 합칠 부분리스트는 a배열의 left ~ right 까지이다.
    // a	    정렬할 배열
    // left	    배열의 시작점
    // mid	    배열의 중간점
    // right	배열의 끝 점
    public void merge(int[] a, int left, int mid, int right) {
        // 왼쪽 부분리스트 시작점
        int l = left;
        // 오른쪽 부분리스트의 시작점
        int r = mid + 1;
        // 채워넣을 배열의 인덱스
        int idx = left;

        System.out.println("배열 시작 번호 : " + left + ", 배열 중간 번호 : " + mid + ", 배열 끝 번호 : " + right);
        while (l <= mid && r <= right) {
            // 왼쪽 부분리스트 l번째 원소가 오른쪽 부분리스트 r번째 원소보다 작거나 같을 경우
            // 왼쪽의 l번째 원소를 새 배열에 넣고 l과 idx를 1 증가시킨다.
            if (a[l] <= a[r]) {
                sorted[idx] = a[l];
                idx++;
                l++;
            } else {
                // 오른쪽 부분리스트 r번째 원소가 왼쪽 부분리스트 l번째 원소보다 작거나 같을 경우
                // 오른쪽의 r번째 원소를 새 배열에 넣고 r과 idx를 1 증가시킨다.
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        }
        System.out.printf("작은 수 : ");
        printArray(sorted);
        // 왼쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (l > mid)
        // = 오른쪽 부분리스트 원소가 아직 남아있을 경우
        // 오른쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
        if (l > mid) {
            while (r <= right) {
                sorted[idx] = a[r];
                idx++;
                r++;
            }
        } else {
            // 오른쪽 부분리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > right)
            // = 왼쪽 부분리스트 원소가 아직 남아있을 경우
            // 왼쪽 부분리스트의 나머지 원소들을 새 배열에 채워준다.
            while (l <= mid) {
                sorted[idx] = a[l];
                idx++;
                l++;
            }
        }
        System.out.printf("나머지 : ");
        printArray(sorted);
        // 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
        for (int i = left; i <= right; i++) {
            a[i] = sorted[i];
        }
        System.out.printf("현재 배열 : ");
        printArray(a);
        System.out.println("---------------------------------------");
    }
}
