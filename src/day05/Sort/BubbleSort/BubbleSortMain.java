package day05.Sort.BubbleSort;

public class BubbleSortMain {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {7, 2, 0, 1, 8, 3, 5};
        bubbleSort.bubbleSort(a);


    /*
        1회전: [ 2 0 1 7 3 5 8 ]
        2회전: [ 0 1 2 3 5 7 8 ]
        3회전: [ 0 1 2 3 5 7 8 ]
        4회전: [ 0 1 2 3 5 7 8 ]
        5회전: [ 0 1 2 3 5 7 8 ]
        6회전: [ 0 1 2 3 5 7 8 ]
        최종 배열 : 0 1 2 3 5 7 8
    */

        Integer[] arr = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int) (Math.random() * 100) + 1;
            arr[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        BubbleSortEx bubbleSortEx = new BubbleSortEx();
        bubbleSortEx.sort(arr.clone());
    }
}
