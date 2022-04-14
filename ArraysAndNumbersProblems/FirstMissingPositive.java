package solutions.ArraysAndNumbersProblems;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0)
            return 1;
        if(nums.length == 1){
            if(nums[0] == 1)
                return 2;
            else
                return 1;
        }
        int n = nums.length;
        for(int i=0; i<n; ){
            if(nums[i] >= 0  && nums[i] < n && nums[i] != i && nums[nums[i]] != nums[i]){
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
            }else{
                i++;
            }
        }
        int i;
        for(i = 1; i<n; i++){
            if(nums[i] != i){
                return i;
            }
        }
        if(nums[0]==i)
        return i+1;
        else
            return i;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        FirstMissingPositive f = new FirstMissingPositive();
        System.out.println(f.firstMissingPositive(arr));
    }
}
