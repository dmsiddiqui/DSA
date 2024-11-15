class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeMax {
    Node root;

    public int minNumber(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        
        int leftMin = minNumber(node.left);
        int rightMin = minNumber(node.right);
        
        return Math.min(node.data, Math.min(leftMin, rightMin));
    }

    public int maxNumber(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = maxNumber(node.left);
        int rightMax = maxNumber(node.right);

        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        BinaryTreeMax  tree = new BinaryTreeMax();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(17);
        tree.root.right.right = new Node(25);

        System.out.println("Minimum value in the binary tree: " + tree.minNumber(tree.root));
        System.out.println("Maximum value in the binary tree: " + tree.maxNumber(tree.root));
    }
}
