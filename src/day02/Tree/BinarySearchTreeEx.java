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
