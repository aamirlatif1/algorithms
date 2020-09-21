package algorithms.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        String b = "";
        findPath(root, b, list);

        return list;
    }

    private static void findPath(TreeNode node, String b, ArrayList<String> list) {
        if (node.left == null && node.right == null) {
            list.add(b + node.val);
        }

        if (node.left != null) {
            findPath(node.left, b + node.val + "->", list);
        }
        if (node.right != null) {
            findPath(node.right, b + node.val + "->", list);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(treeNode));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}