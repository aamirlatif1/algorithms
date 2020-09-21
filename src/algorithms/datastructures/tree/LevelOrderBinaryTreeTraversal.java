package algorithms.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderBinaryTreeTraversal {
    Node root;

    public LevelOrderBinaryTreeTraversal() {
        root = null;
    }


    List<List<Integer>> printLevelOrder() {
        int treeHeight = measureHeight(root);

        List<List<Integer>> treeLevels = new ArrayList<>();
        List<Integer> list = new ArrayList();
        for(int level = 1; level <= treeHeight; level++) {
            getNodesByLevel(list, root, level);
            if(!list.isEmpty()) {
                System.out.println(list.toString());
                treeLevels.add(list);
            }
            list.clear();
        }
        return treeLevels;
    }

    int measureHeight(Node root) {
        if(root == null) {
            return 0;
        } else {
            int leftNodeHeight = measureHeight(root.left);
            int rightNodeHeight = measureHeight(root.right);
            return Math.max(leftNodeHeight+1, rightNodeHeight+1);
        }
    }

    void getNodesByLevel (List list, Node root , int level) {
        if (root == null) {
            return;
        }

        if(level == 1) {
            list.add(root.data);
        }
        else {
            getNodesByLevel(list, root.left, level-1);
            getNodesByLevel(list, root.right, level-1);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        LevelOrderBinaryTreeTraversal tree = new LevelOrderBinaryTreeTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
//        tree.root.left.left= new Node(4);
//        tree.root.left.right= new Node(5);

        tree.printLevelOrder();
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
}
