package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int[] pre;
    int[] in;
    Map<Integer,Integer> mp = new HashMap<>();
    int preIdx,n;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        in = inorder;
        preIdx = 0;
        n = pre.length;
        BinaryTreeZigzagLevelOrderTraversal r;
        for(int i =0; i<in.length; i++){
            mp.put(in[i] , i);
        }
        return construct(0,inorder.length-1);
    }
    TreeNode construct(int treeStart , int treeEnd){
        if(preIdx == n || treeStart > treeEnd)
            return null;
        TreeNode root = new TreeNode(pre[preIdx]);

        int idx = mp.get(pre[preIdx++]);
        if(treeStart == treeEnd)
            return root;
        root.left = construct(treeStart , idx-1);
        root.right = construct(idx+1,treeEnd);
        return root;
    }
}
