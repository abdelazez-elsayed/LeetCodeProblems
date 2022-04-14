package solutions.TreeProblems;

import Datastructure.TreeNode;

class BinaryTreeDiameter {
    int sol=0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        findLongest(root);
        return sol;
    }
    private int findLongest(TreeNode node){
        int left=0,right=0,path;
        if(node.left != null)
            left = findLongest(node.left)+1;
        if(node.right != null)
            right = findLongest(node.right)+1;
        path = left + right;
        if ( path > sol)
            sol = path;
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(1,2,3,4,5);
        BinaryTreeDiameter b = new BinaryTreeDiameter();
        int ans = b.diameterOfBinaryTree(root);
        System.out.println(ans);
    }
}