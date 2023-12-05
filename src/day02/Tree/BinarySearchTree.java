package day02.Tree;

public class BinarySearchTree {
    static final int COUNT = 10;
    TreeNode root;
    // BinarySearchTree 클래스의 생성자에서 null로 초기화될 것.

    public BinarySearchTree() {
        this.root = null;
        // 생성자를 통해 root를 null로 초기화
    }

    public void add(Integer input) {
        TreeNode newTreeNode = new TreeNode(input);
        // 입력받은 input값을 TreeNode의 data에 저장한 새로운 TreeNode 객체 생성

        TreeNode current = this.root;
        // 최초 current를 root로 두고 입력값에 따라 left, right로 이동하고
        // 이동한 위치의 left, right로 노드를 추가한다.

        if (root == null) {
            root = newTreeNode;
            // root가 없으면
            // 입력값을 받아 새로 추가한 newTreeNode 객체를 root에 할당
            // addNode 함수를 호출할 필요 없이 바로 새로운 TreeNode 객체 할당

        } else {
            root = addNode(root, newTreeNode);
            // root가 null이 아니면 어떤 값을 갖고 있는 TreeNode 객체가 저장되어 있다는 뜻이므로
            // 새로운 객체와 기존의 root 노드 객체의 값을 비교해서 새롭게 노드 객체를 트리에 추가해야 한다.
            //  =>
            // root와 새로 추가한 newTreeNode 객체를 parameter로 해서
            // 트리에 새롭게 노드를 추가하는 addNode 함수 재귀 호출
        }
    }

    private TreeNode addNode(TreeNode treeNode, TreeNode newTreeNode) {
        // 비교할 트리의 기존 TreeNode 객체와 새롭게 트리에 추가할 TreeNode 객체를 parameter로 받는 함수.

        if (treeNode == null) {
            return newTreeNode;
            // 새로운 TreeNode 객체를 반환하면 root에 할당됨.

        } else if (treeNode.data > newTreeNode.data) {
            treeNode.left = addNode(treeNode.left, newTreeNode);
            // 만약 기존 treeNode의 값이 새로운 노드 객체 TreeNode의 값보다 크다면
            // 즉, 새로운 입력값에 따른 TreeNode 객체의 값이 기존 treeNode의 값보다 작다면
            // 기존 TreeNode의 left에 노드 추가

        } else {
            treeNode.right = addNode(treeNode.right, newTreeNode);
            // 기존 TreeNode의 값이 새로운 노드 객체 TreeNode의 값보다 작다면
            // 즉, 새로운 입력값에 따른 TreeNode 객체의 값이 기존 TreeNode의 값보다 크다면
            // 기존 TreeNode의 right에 노드 추가
        }
        return treeNode;
        // 마지막으로 새롭게 노드를 추가한 TreeNode 객체 반환하면
        // 앞서 add 함수에서 호출했을 때 반환한 TreeNode 객체가 저장된다.
        // 즉 root가 변하는 것이다.
    }

    public void search(Integer input) {
        searchNode(root, input);
        // 입력값을 받아서 아래 searchNode 함수 호출
    }

    private TreeNode searchNode(TreeNode treeNode, Integer input) {
        if (treeNode == null)
            System.out.println("해당 값은 트리에 존재하지 않습니다.");

        if (input > treeNode.data)
            treeNode.right = searchNode(treeNode.right, input);
            // 입력받은 값을 트리 내에서 찾는 과정에서
            // 다시 treeNode의 오른쪽에서 탐색을 해야 하므로
            // treeNode.right에서 다시 searchNode 함수를 호출.

        else if (input < treeNode.data)
            treeNode.left = searchNode(treeNode.left, input);
            // 다시 treeNode의 왼쪽에서 탐색을 해야 하므로
            // treeNode.left에서 다시 searchNode 함수를 호출.
        else
            System.out.println("해당 값을 가진 노드를 찾았습니다.");

        return treeNode;
    }

    public void descendingTraversal() {
        //내림차순 순회
        System.out.print("내림차순 순회: ");
        rightInorderTraversal(root);
        // 아래에 트리를 우측 중위 순회하는 rightInorderTraversal 함수 호출

        System.out.println();
    }

    private void rightInorderTraversal(TreeNode treeNode){
        // 트리의 우측 중위 순회
        if(treeNode == null)
            return;
        rightInorderTraversal(treeNode.right);
        System.out.printf("%d ", treeNode.data);
        rightInorderTraversal(treeNode.left);
    }

    public void ascendingTraversal() {
        //오름차순 순회
        System.out.print("오름차순 순회: ");
        leftInorderTraversal(root);
        System.out.println();
    }

    private void leftInorderTraversal(TreeNode treeNode) {
        // 좌측 중위 순회
        if(treeNode == null)
            return;
        leftInorderTraversal(treeNode.left);
        System.out.printf("%d ", treeNode.data);
        leftInorderTraversal(treeNode.right);
    }

    // 트리를 확인할 수 있는 함수 (외부 코드 첨부)
    public void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    public void print2D()
    {
        // Pass initial space count as 0
        print2DUtil(this.root, 0);
    }
}
