package day05.InsertSort;

public class InsertSortWithComment {
    /*
        main함수에서 InsertSort 객체 생성후 메소드 실행 시 배열을 매개변수로 넣을 것이기 때문에
        이 InsertSort 클래스에서는 내부 변수 필요 x
     */

    public void insertSortWithComment(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            /*
                index를 1부터 시작하는 이유는 0번째 index값은 배열의 첫 값이므로
                이미 정렬되어 있다고 생각한다. 따라서 index=0부터 비교를 시작하지 않고 1부터 시작하는 것이다.
                그래서 i=1부터 시작하면 i=0과 비교를 하고
                i=2일 때, i=1, i=0과 비교
                i=3일 때, i=2, i=1, i=0와 비교
                ... (반복)
            */

            // 삽입하려는 값 (targetValue) (앞의 값들과 비교해서 적절한 위치에 집어넣을 값)
            int targetValue = arr[i];

            // targetValue과 비교할 값 (targetValue가 저장된 배열의 위치보다 배열에서 하나 앞의 값)
            int previousValueIndex = i - 1;

            /*
                이전의 원소가 더 크다면 배열의 데이터들이 오른쪽으로 한 칸씩 이동한다.
                ex.)
                [3, 5]가 있는 상태에서 4를 삽입한다면
                [3, 5, 4]가 되고
                targetValue = 4가 된다. (index값 x, 실제 배열에 저장된 값 의미 o)
                previousValueIndex = 1이 된다. (index값 o (배열에 저장된 위치), 실제 배열에 저장된 값 의미 x)

                이 상태에서 아래 while 반복문을 돌면서 배열에서 [2]에 저장된 값 4와
                [0]에 저장된 3, [1]에 저장된 5와 값을 비교하며 4가 들어갈 적절한 위치를 찾는다.
            */
            while (previousValueIndex >= 0 && targetValue < arr[previousValueIndex]) {
                /*
                    4보다 앞에 있는 값인 previousValueIndex는 1이다. => while문의 왼쪽 조건 일단 만족

                    targetValue = 4 < arr[1] = 5
                    "배열에 적절한 위치를 찾아서 삽입할 값인 4가 배열의 1번 index값 보다 작다면" 조건이니까
                    배열에 적절한 위치를 찾아서 삽입할 값인 4가 arr[1]=5보다 작으므로 조건 만족

                    while문의 두 조건을 모두 만족하므로 while문 내의 코드 실행.
                */
                arr[previousValueIndex+1] = arr[previousValueIndex];
                /*
                    [3, 5, 4]에서 5가 4보다 크니까 [1]에 저장된 5를 [2]로 이동시키겠다는 의미
                    => [3, 5, 5]가 된 상태.

                    그러면 4가 사라지게 되는데 우리는 4를 기존 배열에서 적절한 위치를 찾아서 삽입해야 하기 때문에,
                    그리고 앞으로 삽입될 값들을 기존 배열(정렬된)에서 적절한 위치를 찾아서 삽입해야 하기 때문에
                    이 값을 기억해야 한다. 그래서 while문 이전에서 int targetValue = arr[i];에서 값을 따로 변수에 저장해두고 있는 것이다.

                    그러면 i가 증가할 때마다 targetValue값이 [i]에 위치한 값으로 (새로 삽입할 값으로) 바뀔 것이고 그럼 그 값들을 배열에서 적절한 위치를 찾아서 삽입할 수 있게 된다.

                    그래서 previousValueIndex가 i-1인데 previousValueIndex에 저장된 값을 하나 다음 칸에 저장하는
                    arr[previousValueIndex+1]=arr[previousValueIndex]; 코드가 실행되어도
                    배열에서 [i]번째 값이 previousValueIndex 위치에 저장되어 있던 값으로 바뀌어도
                    우리는 targetValue 변수에 [i]번째 값을 (삽입하고자 하는 값을) 저장해두었으므로 while문 탈출 이후에
                    적절한 위치에 [i]번째 값을 (삽입하고자 하는 값을) 삽입할 수 있게 된다.
                */
                previousValueIndex -= 1;
                /*
                    그리고 삽입하려는 4와 [0]에 저장된 3과의 비교를 아직 하지 않았으므로
                    previousValueIndex 값을 하나 줄이면
                    previousValueIndex가 위에서 1이었는데 0이 되면서 [0]에 저장된 3과 targetValue=4와의 비교를 할 수 있게 된다.

                    이제 previousValueIndex = 0인 상태에서 다시 while문으로 돌아가서 반복문을 실행한다.

                    previousValueIndex=0이므로 while문의 왼쪽 조건을 만족하는데
                    targetValue = 4 < arr[0] = 3 이므로 while문의 오른쪽 조건을 만족하지 않는다.
                    따라서 while문을 탈출하게 된다.
                */
            }

            /*
                while문을 탈출한다는 건 앞의 원소가 targetValue보다 작다는 의미이다.
                따라서 targetValue=4는 현재 previousValueIndex가 0인데
                [0]번 값인 3보다 크기 때문에
                previousValueIndex보다 하나 뒤에 위치하면 된다.
                따라서 targetValue를 배열의 previousIndexValue에 +1 을 한 위치에 저장한다.

                그럼 최종적으로
                [3, 4, 5]가 정렬되어 삽입 정렬을 마치게 된다.
            */
            arr[previousValueIndex + 1] = targetValue;

            System.out.print(targetValue + " 삽입 -> ");
            printArray(arr);
        }
    }

    /*
        삽입 정렬 과정을 원소가 삽입될 때마다 출력 및 확인하기 위한 메소드
        InsertSort 클래스 내부의 insertSort 메소드 내에서만 사용하기 때문에 private 선언
    */
    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
