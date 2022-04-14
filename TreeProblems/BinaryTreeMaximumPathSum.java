package solutions.TreeProblems;

import Datastructure.TreeNode;

public class BinaryTreeMaximumPathSum {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPaths(root);
        return ans;
    }
    int findMaxPaths(TreeNode root){
        if(root == null)
            return 0;
        int sum=0;
        sum += root.val;
        int right = findMaxPaths(root.right);
        int left = findMaxPaths(root.left);
        sum += right + left;
        if(sum > ans)
            ans = sum;
        if(root.val + right > ans)
            ans = root.val + right;
        if(root.val + left > ans)
            ans = root.val + left;
        if(root.val > ans)
            ans = root.val;
        return Math.max(Math.max(root.val+right,root.val+left),root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(-10,9,20,null,null,15,7);
        BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
        System.out.println(b.maxPathSum(root));
    }
}
