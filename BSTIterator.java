package solutions;

import solutions.Datastructure.TreeNode;


import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushInStack(root);
    }

    public int next() {
        TreeNode tempNode = stack.pop();
        pushInStack(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushInStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
