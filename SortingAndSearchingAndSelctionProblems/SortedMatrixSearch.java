package solutions.SortingAndSearchingAndSelctionProblems;

public class SortedMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;
        int l = 0;
        int r = len-1;
        while(l <= r){
            int mid = (l+r)/2;
            int row = mid / n;
            int col = mid % n;
            int cur = matrix[row][col];
            if(cur == target){
                return true;
            } else if(cur > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int t = 1;
        SortedMatrixSearch s = new SortedMatrixSearch();
        System.out.println(s.searchMatrix(mat,t));
    }
}
