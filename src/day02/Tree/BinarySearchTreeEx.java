package day02.Tree;

public class BinarySearchTreeEx {
    static final int COUNT = 10;
    TreeNode root;

    public BinarySearchTreeEx() {
        this.root = null;
    }

    public void add (Integer input) {
        if (this.root == null) {
            this.root = new TreeNode(input);
        } else {
            TreeNode current = root;
            while (current != null) {
                if (input > current.data) {
                    if (current.right == null) {
                        current.right = new TreeNode(input);
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    if (current.left == null) {
                        current.left = new TreeNode(input);
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    public void add2 (Integer input) {
        if(this.root == null) {
            this.root = new TreeNode(input);
        } else {
            addRecur(this.root, input);
        }
    }

    public TreeNode addRecur (TreeNode treeNode, Integer input) {
        if (treeNode == null) {
            return new TreeNode(input);
        }

        if (input > treeNode.data) {
            treeNode.right = addRecur(treeNode.right, input);
        } else if (input < treeNode.data) {
            treeNode.left = addRecur(treeNode.left, input);
        }
        return treeNode;
    }

    public void remove(Integer input) {
        TreeNode target = this.root;
        TreeNode parents = null;

        if (target != null) {
            // 일단 입력값을 가진 노드를 먼저 찾기
            while (true) {
                if (target.data == input) {
                    break;
                }
                if (input > target.data) {
                    parents = target;
                    target = target.right;
                }
                if (input < target.data) {
                    parents = target;
                    target = target.left;
                }
            }
            // 자식이 없는 리프 노드일 떄 삭제
            if (target.left == null && target.right == null) {
                if (target.data > parents.data) {
                    parents.right = null;
                }
                if (target.data < parents.data) {
                    parents.left = null;
                }
            } else if (target.left != null && target.right == null ||
                    target.left == null && target.right != null) {
                if (target.data > parents.data) {
                    parents.right = target.right;
                    target.right = null;
                }
                if (target.data < parents.data) {
                    parents.left = target.left;
                    target.left = null;
                }
            } else {
                // 왼쪽 기준으로 무한 반복을 돈다.
                TreeNode maximum = target.left;
                TreeNode maximumParents = target;
                while(maximum.right != null) {
                    maximumParents = maximum;
                    maximum = maximum.right;
                }
                if(!maximumParents.equals(target)) {
                    maximumParents.right = maximum.left;
                }

                if(!target.left.equals(maximum)) {
                    maximum.left = target.left;
                }
                maximum.right = target.right;

                if(parents == null) {
                    this.root = maximum;
                } else {
                    if(target.data > parents.data) {
                        parents.right = maximum;
                    }
                    if(target.data < parents.data) {
                        parents.left = maximum;
                    }
                }
            }
        }
    }

    void print2DUtil(TreeNode root, int space)
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
    void print2D()
    {
        // Pass initial space count as 0
        print2DUtil(this.root, 0);
    }

}
