package solutions;

public class ProblemProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {

        int N=nums.length;
        int[] result= new int[N];
        //left to right multiplication
        result[0]=nums[0];
        for(int i=1; i<N;i++){

            result[i]=result[i-1]*nums[i];
        }
        int tmp=1;


        for(int i=N-1; i>=0;i--){
            if(i!=0)
                result[i]=result[i-1]*tmp;
            else {

                result[i] = tmp;
            }

            tmp*=nums[i];

        }
        return result;

    }
}
