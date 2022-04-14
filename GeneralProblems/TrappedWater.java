package solutions.GeneralProblems;

public class TrappedWater {
    public int trap(int[] height) {
        int leftMax = 0,ans = 0;
        int left=0 , right=0;
        for(int i=0; i < height.length; i++){
            if(leftMax <= height[i]){
                for(int j = left; j<i; j++){
                    ans += leftMax-height[j];
                }
                left = i;
                leftMax = height[i];
            }
        }

        if(left != height.length-1){
            int rightMax = 0;
            right = height.length-1;
            for(int i=height.length-1; i >= left; i--){
                if(rightMax <= height[i]){
                    for(int j = right; j>i; j--){
                        ans += rightMax-height[j];
                    }
                    right = i;
                    rightMax = height[i];
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        TrappedWater t = new TrappedWater();
        int[] arr = {0,7,1,4,6};
        System.out.println(t.trap(arr));
    }
}
