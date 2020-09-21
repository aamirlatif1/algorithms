package algorithms.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevelOrderBinaryTreeTraversal_a
{
//    public static String printInOrderTraversal(Node root) {
//        if(root == null) {
//            return "";
//        }
//
//        String s = printInOrderTraversal(root.left);
//        s += " "+ root.data;
//        s += " " + printInOrderTraversal(root.right);
//        return s;
//    }
//    public static List printInOrderTraversal(List list, Node root) {
//        if(root == null) {
//            return list;
//        }
//        printInOrderTraversal(list, root.left);
//        list.add(root.data);
//        printInOrderTraversal(list, root.right);
//        return list;
//    }
    public static List printInOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        list.addAll(printInOrderTraversal(root.left));
        list.add(root.data);
        list.addAll(printInOrderTraversal(root.right));
        return list;
    }

    public static String printPreOrderTraversal(Node root) {
        if(root == null) {
            return "";
        }

        String s = ""+root.data;
        s += " "+ printPreOrderTraversal(root.left);
        s += " " + printPreOrderTraversal(root.right);
        return s;
    }
    public static List printPreOrderTraversal(List list, Node root) {
        if(root == null) {
            return list;
        }

        list.add(root.data);
        printPreOrderTraversal(list, root.left);
        printPreOrderTraversal(list, root.right);
        return list;
    }
    public static void printPreOrderTraversalIterative(Node root) {
        if(root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.data);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }

        System.out.println(list);
    }

    public static String printPostOrderTraversal(Node root) {
        if(root == null) {
            return "";
        }

        String s = printPostOrderTraversal(root.left);
        s += " " + printPostOrderTraversal(root.right);
        s += " "+root.data;
        return s;
    }
    public static void printPostOrderTraversalIterative(Node root) {
        if(root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        do {
            Node node = stack.pop();
            if(node.left != null) {
                stack.push(root.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
            list.add(node.data);
        } while(!stack.isEmpty());

        System.out.println(list);
    }
    public static List printPostOrderTraversal(List list, Node root) {
        if(root == null) {
            return list;
        }
        printPostOrderTraversal(list, root.left);
        printPostOrderTraversal(list, root.right);
        list.add(root.data);
        return list;
    }

    public static int heightOfTree(Node node) {
        if(node == null) {
            return 0;
        }
        return Math.max(heightOfTree(node.left)+1, heightOfTree(node.right)+1);
    }

    public static void printBSF(Node root) {
        int height = heightOfTree(root);
        for(int i=1; i<=height; i++) {
            System.out.println(printNodesAtLevel(root, i));
        }
    }
    public static String printNodesAtLevel(Node node, int level) {
        if(node == null) {
            return "";
        }

        if(level == 1) {
            return " "+node.data;
        }
        else {
            String s = printNodesAtLevel(node.left, level - 1);
            s += printNodesAtLevel(node.right, level - 1);
            return s;
        }
    }

    public static void main(String args[]) {
        Node root= new Node(1);
        root.left= new Node(2);
        root.right= new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);

//        (a) Inorder (Left, Root, Right) : 4 2 5 1 3
//        (b) Preorder (Root, Left, Right) : 1 2 4 5 3
//        (c) Postorder (Left, Right, Root) : 4 5 2 3 1
//        Breadth First or Level Order Traversal : 1 2 3 4 5

//        System.out.println("InOrder   -> "+printInOrderTraversal(root));
//        System.out.println("PreOrder  -> "+printPreOrderTraversal(root));
//        System.out.println("PostOrder -> "+printPostOrderTraversal(root));


//        List<Integer> list = new ArrayList();
//        System.out.println("InOrder   -> "+printInOrderTraversal(root));
//        list.clear();
//        System.out.println("PreOrder  -> "+printPreOrderTraversal(list, root));
//        list.clear();
//        System.out.println("PostOrder -> "+printPostOrderTraversal(list, root));


//        System.out.println("Height   -> "+heightOfTree(root));

//        printBSF(root);

//        printPreOrderTraversalIterative(root);
        printPostOrderTraversalIterative(root);
    }

    static class Node
    {
        int data;
        Node left, right;
        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
}