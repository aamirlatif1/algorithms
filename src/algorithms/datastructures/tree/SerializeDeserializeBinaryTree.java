package algorithms.datastructures.tree;

public class SerializeDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        String str = "";
        if(root == null) {
            return str;
        }

        // TODO: traverse in pre order
        str = str + root.value + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }

    private static TreeNode buildTree(String[] nodes) {
//        TreeNode node = TreeNode();
        return null;
    }

    private static TreeNode buildNode(int index, String[] nodes) {
        return null;
    }

    public static void main(String[] args) {
        int[] tree = {3,5,1,6,2,0,8,-1,-1,7,4};

//        TreeNode node = TreeNode();
    }

    class TreeNode {
        int value;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
