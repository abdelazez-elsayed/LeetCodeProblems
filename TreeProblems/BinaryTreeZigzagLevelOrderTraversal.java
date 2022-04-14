package solutions.TreeProblems;

import Datastructure.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if(root != null)
            s1.push(root);
        while(!s1.isEmpty()){
            List<Integer> lev = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode node = s1.pop();
                lev.add(node.val);
                if(node.left!= null)
                    s2.push(node.left);
                if(node.right != null)
                    s2.push(node.right);
            }
            res.add(lev);
            lev = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode node = s2.pop();
                lev.add(node.val);
                if(node.right != null)
                    s1.push(node.right);
                if(node.left!= null)
                    s1.push(node.left);

            }
            if(!lev.isEmpty())
                res.add(lev);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.newTree(3,9,20,null,null,15,7);
        BinaryTreeZigzagLevelOrderTraversal z = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> r = z.zigzagLevelOrder(root);
        System.out.print("[");
        for(List<Integer> list: r){
            System.out.print("[");
            for(Integer i : list){
                System.out.print(i+",");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
