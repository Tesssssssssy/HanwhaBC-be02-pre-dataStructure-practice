package day05.Sort.InsertSort;

public class InsertSortMainWithComment {
    public static void main(String[] args) {
        // InsertSort 클래스 객체 생성
        InsertSortWithComment insertSort = new InsertSortWithComment();

        // arr1
        int[] arr1 = new int[]{10, 1, 5, 38, 22, 2, 7, 16};
        System.out.println("<삽입 정렬 전>");
        System.out.print("arr1: ");
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println("\n");


        // 삽입정렬 메소드 실행
        System.out.println("삽입 정렬 시행");
        insertSort.insertSortWithComment(arr1);
        System.out.println();

        System.out.println("<삽입 정렬 후>");
        System.out.print("arr1: ");
        for(int i=0; i<arr1.length; i++) {
            System.out.print(arr1[i] + " " );
        }
        System.out.println();


    }
    /*
        위 코드 실행 결과

        <삽입 정렬 전>
        arr1: 10 1 5 38 22 2 7 16

        삽입 정렬 시행
        1 삽입 -> 1 10 5 38 22 2 7 16
        5 삽입 -> 1 5 10 38 22 2 7 16
        38 삽입 -> 1 5 10 38 22 2 7 16
        22 삽입 -> 1 5 10 22 38 2 7 16
        2 삽입 -> 1 2 5 10 22 38 7 16
        7 삽입 -> 1 2 5 7 10 22 38 16
        16 삽입 -> 1 2 5 7 10 16 22 38

        <삽입 정렬 후>
        arr1: 1 2 5 7 10 16 22 38

    */
}
