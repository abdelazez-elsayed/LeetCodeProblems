package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AllNodesDistanceKBinaryTree {
    TreeNode root;
    TreeNode target;
    Map<TreeNode,TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        this.root = root;
        this.target = target;
        parent = new HashMap<>();
        buildParents(null,root);
        List<Integer> ans = new LinkedList<>();
        add(ans,null,target,k);
        return ans;
    }
    void buildParents(TreeNode par,TreeNode node){
        if(node == null)
            return;
        parent.put(node,par);
        buildParents(node,node.left);
        buildParents(node,node.right);
    }
    void add(List<Integer> ans, TreeNode from, TreeNode node, int k){
        if(node == null)
            return;
        if(k == 0){
            ans.add(node.val);
            return;
        }
        if(node.left != null && node.left != from)
            add(ans,node,node.left,k-1);
        if(node.right != null && node.right != from)
            add(ans,node,node.right,k-1);
        TreeNode par = parent.get(node);
        if(par != null && par != from)
            add(ans,node,par,k-1);
    }
}
