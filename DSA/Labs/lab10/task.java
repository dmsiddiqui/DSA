package lab10;
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}
class BinaryTree {
    Node root;
    // Preorder Traversal: Root -> Left -> Right
    void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    // Inorder Traversal: Left -> Root -> Right
    void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);       
        System.out.print(node.data + " "); 
        inorderTraversal(node.right);      
    }
    // Postorder Traversal: Left -> Right -> Root
    void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left); 
        postorderTraversal(node.right);    
        System.out.print(node.data + " "); 
    }
}
public class task {
    public static void main(String[] args) {
        
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder Traversal:");
        tree.preorderTraversal(tree.root); // Output: 1 2 4 5 3

        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree.root);  // Output: 4 2 5 1 3

        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root); // Output: 4 5 2 3 1
    }
}

