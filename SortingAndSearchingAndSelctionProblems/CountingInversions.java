package solutions.SortingAndSearchingAndSelctionProblems;

public class CountingInversions {

    //This method runs in O(N*log(N) ) time
    private long recursiveCountInversions(int[] arr, int start , int end){
        if(end<=start) return 0;
        long count=0;
        int mid = (start + end)/2;
        count += recursiveCountInversions(arr,start,mid);
        count += recursiveCountInversions(arr,mid+1,end);

        count += sort_and_count(arr,start,end);
        return count;
    }
    public long countInversions(int arr[]){
        return recursiveCountInversions(arr,0,arr.length-1);
    }

    //This method runs in O(N^2) time
    public long naiveCountInversions(int arr[]){
        long count=0;
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++)
                if(arr[i]>arr[j])
                    count++;
        }
        return count;
    }

    private long sort_and_count(int[] arr, int start, int end) {
        int i=start;
        int j=(end+start)/2+1; /* mid +1 */
        int mid = j;
        long count_split=0;
        int[] new_arr = new int[end-start+1];
        /*for(int k=0; k<end-start+1; k++){
            if(j > end || arr[i]<=arr[j]){
                new_arr[k]=arr[i++];
            }else if(i > (end+start)/2 || arr[i]>arr[j]){
                new_arr[k]=arr[j++];
                count_split += mid - i;
            }
        }*/
        int k=0;
        while ((i <= mid-1 ) && (j<= end)){

            if(arr[i] >  arr[j]){
                new_arr[k++] = arr[j++];
                count_split += mid - i;

            }else {
                new_arr[k++]=arr[i++];
            }
        }
        while (j<=end){
            new_arr[k++]=arr[j++];
        }
        while (i <= mid-1){
            new_arr[k++] = arr[i++];
        }
        setArr(arr,new_arr,start,end);
        return count_split;
    }
    private void setArr(int[] arr , int[] new_arr,int start,int end){
        for(int i=start; i<=end;i++)
            arr[i] = new_arr[i-start];
    }
}
