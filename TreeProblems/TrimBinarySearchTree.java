package solutions.TreeProblems;

import Datastructure.TreeNode;


//Problem 669
// https://leetcode.com/problems/trim-a-binary-search-tree/
public class TrimBinarySearchTree {
    int l,h;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        l = low;
        h = high;
        return trim(root);
    }
    TreeNode trim(TreeNode root){
        if(root == null)
            return null;
        if(inRange(root)){
            root.left = trim(root.left);
            root.right = trim(root.right);
            return root;
        }
        if(root.val < l)
            return trim(root.right);

        return trim(root.left);
    }
    boolean inRange(TreeNode root){
        return root.val >= l && root.val <= h;
    }
}
