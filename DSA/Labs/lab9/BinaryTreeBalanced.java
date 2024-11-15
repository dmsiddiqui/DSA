class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BinaryTreeBalanced {
    public boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);
        
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeBalanced tree = new BinaryTreeBalanced();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        if (tree.isBalanced(root)) {
            System.out.println("The binary tree is height balanced.");
        } else {
            System.out.println("The binary tree is not height balanced.");
        }
    }
}
