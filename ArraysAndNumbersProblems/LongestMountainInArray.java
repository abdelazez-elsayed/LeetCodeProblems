package solutions.ArraysAndNumbersProblems;

public class LongestMountainInArray {
    public int longestMountain(int[] arr) {
        int ans = 0;
        int n = arr.length;
        int start = 0;
        for(int i=0; i<n-1;){
            if(arr[i+1] > arr[i]){
                while(i<n-1 && arr[i+1] > arr[i])
                    i++;
                if(i < n-1 && arr[i] > arr[i+1]){
                    while(i<n-1 && arr[i] > arr[i+1])
                        i++;
                    ans = Math.max(ans , i-start +1 );
                }
                start = i;

            }else{
                i++;
                start = i;
            }
        }
        return ans;
    }
}
