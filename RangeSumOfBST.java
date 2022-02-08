package solutions;

import solutions.Datastructure.TreeNode;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int ans = 0;
        if(root == null)
            return 0;
        if(inRange(root.val,low,high)){
            ans += root.val;
        }
        if(root.left != null){
            if(root.val >= low)
                ans += rangeSumBST(root.left,low,high);
        }
        if(root.right != null){
            if(root.val <= high)
                ans += rangeSumBST(root.right,low,high);
        }
        return ans;
    }
    boolean inRange(int v,int l,int h){
        return v>= l && v <= h;
    }

}
