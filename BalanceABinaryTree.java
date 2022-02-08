package solutions;

import solutions.Datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinaryTree {
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        traverse(root);
        return build(0,list.size()-1);
    }
    void traverse(TreeNode root){
        if(root == null )
            return;
        traverse(root.left);
        list.add(root);
        traverse(root.right);
    }
    TreeNode build(int start , int end){
        if(start > end || start >= list.size() || end < 0)
            return null;
        int mid  = (start+end)/2;
        TreeNode root =  list.get(mid);
        root.left = build(start,mid-1);
        root.right = build(mid+1,end);
        return root;
    }
}
