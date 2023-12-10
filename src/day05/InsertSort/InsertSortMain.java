package day05.InsertSort;

public class InsertSortMain {
    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();

        int[] arr1 = new int[]{10, 1, 5, 38, 22, 2, 7, 16};
        System.out.println("<삽입 정렬 전>");
        System.out.print("arr1: ");
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println("\n");

        System.out.println("삽입 정렬 시행");
        insertSort.insertSort(arr1);
        System.out.println();

        System.out.println("<삽입 정렬 후>");
        System.out.print("arr1: ");
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println();
    }
}
