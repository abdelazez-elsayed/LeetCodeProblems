package solutions.ArraysAndNumbersProblems;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        for(int i=0; i<m; i++){
            if(n==0)
                return true;
            if(flowerbed[i] != 1){
                boolean vl,vr;
                if(i-1 >= 0){
                    vl = flowerbed[i - 1] != 1;
                }else vl = true;

                if(i+1 < m){
                    vr = flowerbed[i + 1] != 1;
                }else{
                    vr =true;
                }
                if(vl && vr){
                    n-- ;
                    flowerbed[i] = 1;
                }

            }
        }
        return n==0;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arr = {1,0,0,0,0,1};
        CanPlaceFlowers c = new CanPlaceFlowers();
        boolean ans = c.canPlaceFlowers(arr,n);
        System.out.println(ans);
    }
}
