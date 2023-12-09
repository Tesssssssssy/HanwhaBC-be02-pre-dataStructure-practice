package day04.RedBlackTreeEx;

public class RedBlackTree {

    private static final int BLACK = 0;
    private static final int RED = 1;
    RedBlackNode root;


    public void insert(int value){
        insertNode(new RedBlackNode(value));

    }
    public void insertNode(RedBlackNode node) {


        // 트리가 비었는지 확인
        if(root == null) {
            // 루트가 없는 경우, 검은색 루트 노드를 새로 만들며 시작 (조건 1.1.)
            node.setColor(BLACK);
            root = node;
        }
        else {
            // 루트 노드가 있는 경우, 빨간색 리프 노드를 삽입 (조건 1.2.)
            node.setColor(RED);
            RedBlackNode parent = root;


            // 기본 이진트리 규칙대로 노드 추가하기 (빨간색 리프 노드의 자리 찾기)
            while(true) {
                // 노드의 값이 부모보다 크다면 계속 오른쪽 자식을 부모로 접근
                if(node.getValue() > parent.getValue()) {
                    // 부모의 오른쪽 자식 자리가 비었다면, 오른쪽 자식이 됨
                    if(parent.right == null) {
                        parent.right = node;
                        node.parent = parent;
                        break;
                    }
                    else {
                        // 트리에서 한줄기 오른쪽으로 내려와서 빈공간 찾기 (while)
                        parent = parent.right;
                    }
                }
                // 노드의 값이 부모보다 작다면 계속 왼쪽 자식을 부모로 접근
                else {
                    // 부모의 왼쪽 자식 자리가 비었다면, 왼쪽 자식이 됨
                    if(parent.left == null) {
                        parent.left = node;
                        node.parent = parent;
                        break;
                    } else {
                        // 트리에서 한줄기 왼쪽으로 내려와서 빈공간 찾기 (while)
                        parent = parent.left;
                    }
                }
            }

            // 새 노드의 부모가 빨간색일 때만 새 노드의 부모의 형제 확인 및 재색칠, 회전 적용 (조건 1.2.2.)
            if(node.parent != null && "RED".equals(node.parent.getColor())){
                recolorTree(node);
            }
        }
    }

    public void recolorTree(RedBlackNode node) {

        // 부모의 색이 빨간색이 아닐 때까지 재색칠을 할 것이다.
        while (node.parent != null && "RED".equals(node.parent.getColor())) {
            RedBlackNode siblingOfParent = null;

            // 해당 노드 부모가 조부모 노드의 왼쪽노드 자식이라면 (회전 방향 정하기)
            if(node.parent == node.parent.parent.left) {
                // 부모의 형제는 부모의 부모의 오른쪽노드 자식이다. (부모는 왼쪽 노드 자식이기 때문)
                siblingOfParent = node.parent.parent.right;

                // 부모의 형제가 빨간색이라면 (1.2.2.2)
                if(siblingOfParent != null && "RED".equals(siblingOfParent.getColor())) {
                    node = whenSiblingOfParentIsRed(node, siblingOfParent);
                    continue;
                }

                // 내 부모의 형제가 검은색이라면 (1.2.2.1) -> 회전 + 재색칠
                else {
                    // 내가 부모 기준 우측에 있는 자식이라면, 좌측 회전
                    if(node == node.parent.right) {
                        node = node.parent;
                        rotateLeft(node);
                    }

                    // 부모의 색이 빨간색인 것이 실행 조건이었으니,
                    // 내 부모의 색은 검은색을 만들어줌 (재색칠)
                    node.parent.setColor(BLACK);
                    // 내 부모의 부모는 빨간색이 됨 (재색칠)
                    node.parent.parent.setColor(RED);

                    // 내 부모의 부모를 우측 회전시키기
                    rotateRight(node.parent.parent);
                    break;
                }
            }

            // 내 부모가 / 조부모 노드의 오른쪽 자식이라면 (회전 방향 정하기)
            else {
                // 부모 노드의 형제는 부모 노드의 부모 노드의 왼쪽 자식이다. (부모는 오른쪽 노드 자식이기 때문)
                siblingOfParent = node.parent.parent.left;

                // 내 부모의 형제가 빨간색이라면 (1.2.2.2)
                if(siblingOfParent != null && "RED".equals(siblingOfParent.getColor())) {
                    node = whenSiblingOfParentIsRed(node, siblingOfParent);
                    continue;
                }

                // 내 부모의 형제가 검은색이라면 (1.2.2.1) -> 회전 + 재색칠
                else {
                    // 내가 부모 기준 좌측에 있는 자식이라면, 우측 회전
                    if(node == node.parent.left) {
                        node = node.parent;
                        rotateRight(node);
                    }

                    // 부모의 색이 빨간색인 것이 실행 조건이었으니,
                    // 내 부모의 색은 검은색을 만들어줌 (재색칠)
                    node.parent.setColor(BLACK);
                    // 내 부모의 부모는 빨간색이 됨 (재색칠)
                    node.parent.parent.setColor(RED);

                    // 내 부모의 부모를 좌측 회전시키기
                    rotateLeft(node.parent.parent);
                    break;
                }
            }
        }

        root.setColor(BLACK);
    }

    public RedBlackNode whenSiblingOfParentIsRed(RedBlackNode node, RedBlackNode siblingOfParent) {
        // 부모를 검정으로 만듦 (부모의 형제가 빨간색인 것이 밝혀졌으니, 부모도 빨간색일 것임)
        node.parent.setColor(BLACK);
        // 부모의 형제도 검정으로 만듦
        siblingOfParent.setColor(BLACK);
        // 부모의 부모는 빨강으로 만듦 (이래야 5. 조건이 만족됨)
        node.parent.parent.setColor(RED);

        //부모의 부모를 반환하고, 다시 반복해서 부모의 부모의 부모가 또 빨간색이면 같은 행위(재색칠)를 반복해야 함
        return node.parent.parent;
    }

    private void rotateLeft(RedBlackNode node) {

        // 부모가 존재하지 않을 때
        if(node.parent == null) {
            RedBlackNode right = root.right;
            root.right = root.right.left;
            right.left = new RedBlackNode();
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = null;
            root = right;
        }

        // 부모가 존재한다면,
        else {
            // 해당 노드가 왼쪽 자식이라면 (해당 노드가 부모 노드보다 작다면)
            // 해당 노드의 오른쪽 자식은 해당 노드보다 크지만, 부모 노드보다는 작음
            if(node == node.parent.left) {
                node.parent.left = node.right;
            }
            // 해당 노드가 오른쪽 자식이라면 (해당 노드가 부모 노드보다 크다면)
            // 해당 노드의 오른쪽 자식도 해당 노드의 부모보다 큼
            else {
                node.parent.right = node.right;
            }

            node.right.parent = node.parent;
            node.parent = node.right;

            if(node.right.left != null) {
                node.right.left.parent = node;
            }

            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    private void rotateRight(RedBlackNode node) {

        if(node.parent == null) {
            RedBlackNode left = root.left;
            root.left = root.left.right;
            left.right = new RedBlackNode();
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = null;
            root = left;
        }

        // 부모가 존재한다면,
        else {
            // 해당 노드가 왼쪽 자식이라면 (해당 노드가 부모 노드보다 작다면)
            // 해당 노드의 왼쪽 자식도 부모 노드보다 작음
            if(node == node.parent.left) {
                node.parent.left = node.left;
            }
            // 해당 노드가 오른쪽 자식이라면 (해당 노드가 부모 노드보다 크다면)
            // 해당 노드의 왼쪽 자식도 부모 노드보다 큼
            // (조부모 노드보다 작았다면 조부모노드의 왼쪽 방향에 삽입되어야 하기 때문)
            else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;

            if(node.left.right != null) {
                node.left.right.parent = node;
            }

            node.left = node.left.right;
            node.parent.right = node;
        }
    }
}
