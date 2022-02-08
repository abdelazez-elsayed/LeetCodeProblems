package solutions;

import solutions.Datastructure.TreeNode;

public class LowestCommonAncestorBT {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        TreeNode left=null,right=null;
        if(root.left != null)
            left = lowestCommonAncestor(root.left,p,q);
        if(root.right != null)
            right = lowestCommonAncestor(root.right,p,q);
        if(right != null && left != null)
            return root;
        else
            return left == null ? right : left;
    }
}
