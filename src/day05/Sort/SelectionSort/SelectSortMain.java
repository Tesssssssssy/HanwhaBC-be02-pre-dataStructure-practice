package day05.Sort.SelectionSort;

public class SelectSortMain {
    public static void main(String[] args) {
        Integer[] arr = new Integer[10];
        System.out.print("정렬 전 : ");
        for (int i = 0; i < 10; i++) {
            Integer num = (int)(Math.random()*100) + 1;
            arr[i] = num;
            System.out.print(num + " ");
        }
        System.out.println();

        SelectSort selectSort = new SelectSort();
        selectSort.sort(arr.clone());


    }
}
