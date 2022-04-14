package solutions.TreeProblems;


import Datastructure.TreeNode;

public class DiameterOfBinaryTree {
    int sol=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        findLongest(root);
        return sol;
    }
    private int findLongest(TreeNode node){
        int left=0,right=0,path=0;
        if(node.left != null)
            left = findLongest(node.left)+1;
        if(node.right != null)
            right = findLongest(node.right)+1;
        path = left + right;
        if ( path > sol)
            sol = path;
        return Math.max(left,right);
    }
}
