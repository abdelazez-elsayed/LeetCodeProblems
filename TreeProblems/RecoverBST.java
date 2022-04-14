package solutions.TreeProblems;

import Datastructure.TreeNode;

public class RecoverBST {
    TreeNode n1,n2;
    TreeNode prv = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        TreeNode cur  = root;
        while(cur != null){
            if(cur.left == null){
                //do

                if(n1 == null && prv.val > cur.val)
                    n1 = prv;
                if(n1 != null && prv.val > cur.val)
                    n2 = cur;
                prv = cur;

                //
                System.out.println(cur.val);
                cur=cur.right;
            }else{
                TreeNode predecessor = findPredecessor(cur);
                if(predecessor.right == null){
                    predecessor.right = cur;
                    cur = cur.left;
                }else{
                    predecessor.right = null;
                    //do

                    if(n1 == null && prv.val > cur.val)
                        n1 = prv;
                    if(n1 != null && prv.val > cur.val)
                        n2 = cur;
                    prv = cur;

                    //
                    cur = cur.right;
                }
            }
        }
        swapNodes(n1,n2);
    }
    TreeNode findPredecessor(TreeNode root){
        if(root == null)
            return null;
        TreeNode node = root.left;
        while (node.right != null && node.right != root)
            node = node.right;
        return node;
    }
    void recover(TreeNode node){
        if(node == null)
            return;

        recover(node.left);
        if(n1 == null && prv.val > node.val)
            n1 = prv;
        if(n1 != null && prv.val > node.val)
            n2 = node;
        prv = node;
        recover(node.right);
    }
    void swapNodes(TreeNode n1, TreeNode n2){
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }
    void inorder(TreeNode root){
        if(root == null)return;
        inorder(root.left);
        System.out.println(root.val+", ");
        inorder(root.right);
    }

}
