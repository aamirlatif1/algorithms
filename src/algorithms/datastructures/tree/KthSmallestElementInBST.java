package algorithms.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = convertTreeToInOrderArray(root);

        if(k >= list.size()) {
            return 0;
        }

        int counter = 0;
        int value = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != -1) {
                counter++;
            }
            if(counter == k) {
                value = list.get(i);
                break;
            }
        }
        return value;
    }

    public static List<Integer> convertTreeToInOrderArray(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            list.add(-1);
            return list;
        }

        list.addAll(convertTreeToInOrderArray(root.left));
        list.add(root.val);
        list.addAll(convertTreeToInOrderArray(root.right));

        return list;
    }

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left= new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
    }
}
