package solutions;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] arr) {
        int n = arr.length , k=n;
        int p = 1;
        int lastSeen = arr[0];
        int seenCount = 1;
        int maxCopy = 2; // Max Number of Copies to be hold
        for(int i=1;i<n;i++){
            if(arr[i] == lastSeen){
                seenCount++;
                if(seenCount > maxCopy){
                    k--;
                    seenCount--;

                }else{
                    arr[p++] = arr[i];
                }
            }
            else{
                lastSeen =arr[i];
                arr[p++] = arr[i];
                seenCount = 1;
            }
        }
        return k;
    }
}
