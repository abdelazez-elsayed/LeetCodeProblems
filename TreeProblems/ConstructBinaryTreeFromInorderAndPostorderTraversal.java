package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    int[] pos;
    int[] in;
    Map<Integer,Integer> mp = new HashMap<>();
    int posIdx,n;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pos = postorder;
        in = inorder;
        n = in.length;
        posIdx = n-1;

        for(int i =0; i<in.length; i++){
            mp.put(in[i] , i);
        }
        return construct(0,inorder.length-1);
    }
    TreeNode construct(int treeStart , int treeEnd){
        if(posIdx == n || treeStart > treeEnd)
            return null;
        TreeNode root = new TreeNode(pos[posIdx]);

        int idx = mp.get(pos[posIdx--]);
        if(treeStart == treeEnd)
            return root;
        root.right = construct(idx+1,treeEnd);
        root.left = construct(treeStart , idx-1);

        return root;
    }
}
