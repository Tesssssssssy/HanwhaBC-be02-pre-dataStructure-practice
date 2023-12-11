package day05.AstarMyVer;

public class AstarEx {
    final Integer DEFAULT_COST = 10;
    final Integer DEFAULT_DIAGONAL_COST = 14;


    // 맵의 크기 저장 변수


    // 초기화할 때 맵 정보를 전달 받아서 출발지와 목적지의 좌표를 변수에 저장
    Integer[][] map;

    Node start;

    Node goal;

    // 열린 목록 저장할 변수

    // 닫힌 목록 저장할 변수



    public AstarEx(Integer[][] map) {
        this.map = map;


        // 맵 크기 초기화

        // 열린 목록 초기화

        // 닫힌 목록 초기화

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1) {
                    this.start = new Node(j, i);
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 2) {
                    this.goal = new Node(j, i);
                }
            }
        }
    }

    public void findPath() {
        // 시작점를 '열린 목록'에 넣는다.

        // 열린 목록이 비어 있지 않으면 반복, 리스트가 비어있는지 아닌지 확인은 리스트변수.isEmpty()
//        while(/*열린 목록이 비어있지 않으면*/) {
////            열린 목록에서 제일 처음 노드를 가져온다(가져온 노드는 목록에서 삭제)
//
////            가져온 노드는 닫힌 목록에 넣어준다.
//
////            만약 가져온 노드가 최종 목적지면
//            if(goal.equals(/*가져온 노드*/) ) {
////                  최종 경로 출력
//            }
////            그렇지 않으면
//            else {
//                // addAdjacentNodes 메소드 실행
//
//            }
//        }
    }

    public Boolean isDuplicate(Node adjacentNode) {
        // 열린 목록에 있는 노드를 하나씩 가져오면서 반복
        // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
        //      중복

        // 닫힌 목록에 있는 노드를 하나씩 가져오면서 반복
        // 가져온 노드의 x와 전달받은 노드의 x가 같고 가져온 노드의 y와 전달받은 노드의 Y가 같으면
        //      중복

        // 중복 아님
        return false;
    }

    public void addAdjacentNodes(Node currentNode) {
        // 전달 받은 노드의 X,Y 좌표를 따로 저장

        // 왼위, 위, 오위, 왼, 오, 왼아, 아, 오아
        // 인접한 좌표가 맵 크기를 넘지 않고 맵에서 장애물이 아니면
        // FGH 계산해서 각각 변수에 저장
        // 새로운 노드 생성(전달해줄거 전달해서 생성)
        // isDuplicate 메소드 실행해서 결과를 저장
        // 만약에 isDuplicate 메소드 실행 결과가 거짓이면
        //      생성한 노드를 열린 목록에 넣는다
        //      F 값을 기준으로 정렬 오름차순 정렬
    }
}
