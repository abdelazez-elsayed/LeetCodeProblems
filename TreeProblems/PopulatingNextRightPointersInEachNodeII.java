package solutions.TreeProblems;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}



//This solution works for both complete and incomplete tree

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root==null) return null;
        Node cur = root;
        Node nextLevel = root.left != null ? root.left : root.right;
        Node prv = null;
        while(nextLevel != null){
            prv = null;
            nextLevel = null;
            while(cur != null){
                if(nextLevel == null){
                    nextLevel = cur.left != null ? cur.left : cur.right;
                }
                if(cur.left != null){
                    if(prv != null){
                        prv.next = cur.left;
                    }
                    prv = cur.left;
                }
                if(cur.right != null){
                    if(prv != null){
                        prv.next = cur.right;
                    }
                    prv = cur.right;
                }
                cur = cur.next;

            }
            cur = nextLevel;
        }
        return root;

    }
}
