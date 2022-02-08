package solutions;

import solutions.Datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

public class ConstructBinaryTreeFromString {
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    String s ;
    public TreeNode str2tree(String s) {
        // write your code here
        this.s = s ;
        return cons( 0 , s.length());
    }
    TreeNode cons(int start , int end){
        int sign = 1;
        int base = 0;
        TreeNode root;
        TreeNode left=null,right=null;
        boolean leftSet = false;
        for(int i = start; i<end;){
            if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(Character.isDigit(s.charAt(i))){
                base = base * 10 + s.charAt(i) - '0';
                i++;
            }
            else if(s.charAt(i) == '('){
                int j=i+1;
                int l = 1;
                while(l != 0){
                    if(s.charAt(j) == '('){
                        l++;
                    }
                    else if(s.charAt(j) == ')' ){
                        l--;
                    }
                    j++;
                }
                if(!leftSet){
                    leftSet = true;
                    String tmp = s.substring(i,j-1);
                    left = cons(i+1,j-1);

                }else{
                    right = cons(i+1,j-1);
                }
                i = j;

            }
            ArrayList<Integer> list = new ArrayList<>();
            list.sort(Comparator.comparingInt(a -> a));

        }
        root = new TreeNode(sign*base);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        String s= "-4(2(3)(1))(6(5))";
        ConstructBinaryTreeFromString c = new ConstructBinaryTreeFromString();
        c.str2tree(s);
    }
}
