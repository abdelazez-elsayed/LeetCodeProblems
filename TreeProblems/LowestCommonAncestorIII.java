package solutions.TreeProblems;

import Datastructure.TreeNode;

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // write your code here

        boolean left = search(root,p);
        boolean right = search(root,q);
        if(left && right)
            return find(root,p,q);
        return null;

    }
    TreeNode find(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        TreeNode left=null,right=null;

        if(root.left != null) left = find(root.left,p,q);
        if(root.right != null) right = find(root.right,p,q);

        if(right != null && left != null)
            return root;
        else
            return left != null ? left : right;
    }
    boolean search(TreeNode root,TreeNode node){
        if(root == null)
            return false;
        if(root.val == node.val)
            return true;
        boolean ans = false;
        ans = search(root.left,node) || search(root.right,node);
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(4,3,7,null,null,5,6);
        LowestCommonAncestorIII l = new LowestCommonAncestorIII();
        l.lowestCommonAncestor3(root,new TreeNode(6),new TreeNode(5));
    }


}
