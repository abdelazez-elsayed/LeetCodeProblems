class MaxContainer {
    public int maxArea(int[] height) {
        int maxArea=0;
        int area;
        int i=0;
        int j=height.length-1;
        
        while(i<j){
            area = Math.min(height[i],height[j])*(j-i);
            if(area > maxArea) maxArea = area;
            if(height[i] > height[j])
                j--;
            else
                i++;
                
        }
        return maxArea;
    }

}