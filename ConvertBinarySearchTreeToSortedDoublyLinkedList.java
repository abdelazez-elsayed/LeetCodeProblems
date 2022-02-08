package solutions;

import solutions.Datastructure.TreeNode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        // Write your code here.
        if(root == null)
            return null;

        TreeNode[] list = traverse(root);
        list[0].left = list[1];
        list[1].right = list[0];
        return list[0];

    }
    TreeNode[] traverse(TreeNode root){
        TreeNode[] list = new TreeNode[2];
        TreeNode left = root ,right = root;
        TreeNode[] leftRes, rightRes;
        if(root.left != null){
            leftRes = traverse(root.left);
            left = leftRes[0];
            root.left = leftRes[1];
            leftRes[1].right = root;
        }
        if(root.right != null){
            rightRes = traverse(root.right);
            right = rightRes[1];
            root.right = rightRes[0];
            rightRes[0].left = root;
        }
        list[0] = left;
        list[1] = right;
        return list;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(62,23,65,6,null,null,4,16);
        ConvertBinarySearchTreeToSortedDoublyLinkedList c = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        TreeNode r =c.treeToDoublyList(root);

    }
}
