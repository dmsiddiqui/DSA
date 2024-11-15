class BinaryTree {
    
    Node root;
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public void addNode(int data) {
        try {
            root = addNodeRecursive(root, data);
        } catch (Exception e) {
            System.out.println("Error while adding node: " + e.getMessage());
        }
    }

    private Node addNodeRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = addNodeRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = addNodeRecursive(current.right, data);
        } else {
            System.out.println("Duplicate values are not allowed.");
        }

        return current;
    }

    public boolean searchNode(int data) {
        try {
            return searchNodeRecursive(root, data);
        } catch (Exception e) {
            System.out.println("Error while searching node: " + e.getMessage());
            return false;
        }
    }

    private boolean searchNodeRecursive(Node current, int data) {
        if (current == null) {
            return false;
        }
        if (data == current.data) {
            return true;
        }

        return data < current.data
                ? searchNodeRecursive(current.left, data)
                : searchNodeRecursive(current.right, data);
    }

    public int countOfNodes(Node root) {
        try {
            if (root == null) {
                return 0;
            }
            return 1 + countOfNodes(root.left) + countOfNodes(root.right);
        } catch (Exception e) {
            System.out.println("Error while counting nodes: " + e.getMessage());
            return -1;
        }
    }

    public int height(Node root) {
        try {
            if (root == null) {
                return -1; 
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        } catch (Exception e) {
            System.out.println("Error while calculating height: " + e.getMessage());
            return -1;
        }
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.addNode(50);
        tree.addNode(30);
        tree.addNode(70);
        tree.addNode(20);
        tree.addNode(40);
        tree.addNode(60);
        tree.addNode(80);
        System.out.println("Is 40 present? " + tree.searchNode(40));
        System.out.println("Is 100 present? " + tree.searchNode(100));
        System.out.println("Total number of nodes: " + tree.countOfNodes(tree.root));
        System.out.println("Height of the tree: " + tree.height(tree.root));
    }
}
