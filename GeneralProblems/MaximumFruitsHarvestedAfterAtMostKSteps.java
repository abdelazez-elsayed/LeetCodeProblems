package solutions.GeneralProblems;

public class MaximumFruitsHarvestedAfterAtMostKSteps {
    int n;
    int[] rightSums;
    int[] leftSums;
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        n = fruits.length;
        leftSums = new int[n];
        rightSums = new int[n];
        int sum=0;
        int startFruits = 0;
        for(int i=0;i<n;i++){
            if(fruits[i][0] >= startPos){
                if(fruits[i][0] == startPos)startFruits = fruits[i][1];
                sum+= fruits[i][1];
                rightSums[i] = sum;
            }
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(fruits[i][0] <= startPos){
                sum+= fruits[i][1];
                leftSums[i] = sum;
            }
        }
        int maxRight = findMaxRight(fruits,startPos,k);
        int maxLeft = findMaxLeft(fruits,startPos,k);
        int ans = 0;
        ans = maxRight != -1 ? rightSums[maxRight]:0;
        ans = maxLeft != -1 ? Math.max(ans,leftSums[maxLeft]) : ans;
        if(maxLeft == -1 || maxRight == -1)
            return ans;
        int harvested = 0;
        for(int i=maxLeft; i<= maxRight; i++){

            int pos = fruits[i][0];
            int remainSteps = k-Math.abs(startPos-pos)*2;
            if(pos < startPos){
                int reachableRight = findMaxRight(fruits,startPos,remainSteps);
                if(reachableRight != -1){
                    harvested = leftSums[i]+rightSums[reachableRight]-startFruits;
                }
            }else{
                int reachableLeft = findMaxLeft(fruits,startPos,remainSteps);
                if(reachableLeft != -1)
                    harvested = rightSums[i]+leftSums[reachableLeft]-startFruits;
            }
            ans= Math.max(ans,harvested);
        }
        return ans;
    }

    int findMaxRight(int[][] fruits,int start,int k){
        int l = 0, h=n-1;
        int ans = -1;
        if(start < 0)
            return -1;
        while(l <= h){
            int mid = l + (h-l)/2;
            int pos = fruits[mid][0];
            if(pos -start <= k){
                ans=mid;
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return ans;
    }

    int findMaxLeft(int[][] fruits,int start,int k){
        int l = 0, h=n-1;
        int ans = -1;
        if(start < 0)
            return -1;
        while(l <= h){

            int mid = l + (h-l)/2;
            int pos = fruits[mid][0];
            if(start-pos <= k){
                ans=mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] fruits2 = {{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}};
        int k2 = 4;
        int s2 = 5;
        MaximumFruitsHarvestedAfterAtMostKSteps m = new MaximumFruitsHarvestedAfterAtMostKSteps();
        int ans = m.maxTotalFruits(fruits2,s2,k2);
        System.out.println(ans);
    }
}
