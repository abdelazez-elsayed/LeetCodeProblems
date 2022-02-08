package solutions;

import solutions.Datastructure.TreeNode;

import java.util.Stack;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        int lv;
        int rv;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int n = Integer.numberOfTrailingZeros(24);
        while(p != null && q != null || !s1.empty() || !s2.empty()){
            while(q != null && p != null){
                s1.push(p);
                s2.push(q);
                p = p.left;
                q = q.left;
            }
            
            p = s1.pop();
            q = s2.pop();
            if(q.val != p.val)
                return false;
            p = p.right;
            q = q.right;
        }
        return (p == null && q == null);
    }
}
