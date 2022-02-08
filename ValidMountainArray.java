package solutions;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3)
            return false;
        int n = arr.length;
        if(arr[0] >= arr[1]  || arr[n-1] >= arr[n-2])
            return false;
        int i=1;
        for(; i<n; i++)
            if (arr[i - 1] >= arr[i])
                break;

        for(; i< n; i++)
            if (arr[i - 1] <= arr[i])
                return false;
        return true;
    }
}
