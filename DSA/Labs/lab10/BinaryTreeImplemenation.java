package lab10;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeImplemenation{
    static class Node {
        int val;
        Node left, right;
    
        public Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    static class BinaryTree {
    
        static int idx = -1;
        public Node createTree(int[] nodes){
            idx++;
            if(idx >= nodes.length || nodes[idx] == -1){
                return null;
            }
            Node node = new Node(nodes[idx]);
            node.left=createTree(nodes);
            node.right=createTree(nodes);
    
            return node;
    
        }
        
    }
    public static void LevelOrder(Node root){
        if(root==null){
            System.out.println("Tree Empty!");
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(!q.isEmpty()){
                    q.add(null);
                }
                else if(q.isEmpty()){
                    break;
                }
            }
                else{
                    System.out.print(curr.val + " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
        }
    
    public static boolean isIdentical(Node x, Node y){
        if(x == null && y == null){
            return true;
        }
        else if(x == null || y == null ){
            return false;
        }
        else{
            if(x.val == y.val){
                boolean left = isIdentical(x.left, y.left);
                boolean right = isIdentical(x.right, y.right);
                return left && right;
            }
            return false;
        }
    }
    public static boolean isSubtree(Node x, Node y){
        if(x == null){
            return false;
        }
        if(isIdentical(x, y)){
            return true;
        }
        return isSubtree(x.left,y) || isSubtree(x.right,y);
    }

    public static void main(String[] args) {
        int[] nodeX = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
        int[] nodeY = {1,4,2,-1,-1};
        BinaryTree tree = new BinaryTree();

        Node rootX = tree.createTree(nodeX);
        tree.idx=-1;
        Node rootY = tree.createTree(nodeY);  
        
        System.out.println(isSubtree(rootX, rootY));


        // Node root = tree.createTree(nodeX);
        // LevelOrder(root);
        
        // Node rootX = tree.createTree(nodeX);
        // tree.idx=-1;
        // Node rootY = tree.createTree(nodeY);
        // System.out.println(isIdentical(rootX, rootY));
    }
}



