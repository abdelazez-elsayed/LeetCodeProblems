package solutions;

import solutions.Datastructure.TreeNode;

public class FlattenBST {
    private TreeNode prev;
    public void flatten(TreeNode root){
        if(root == null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(1,2,5,3,4,null,6);
        FlattenBST f = new FlattenBST();
        f.flatten(root);
    }
}
