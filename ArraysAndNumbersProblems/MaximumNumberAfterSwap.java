package solutions.ArraysAndNumbersProblems;

public class MaximumNumberAfterSwap {
    public int maximumSwap(int num) {
        char[] digits= Integer.toString(num).toCharArray();
        int n = digits.length;
        for(int i = 0; i<n; i++){
            int max = digits[i]-'0' +1;
            boolean swap = false;
            int idx = 0;
            for(int j=i+1; j<n; j++){
                int dj = digits[j] - '0' ;
                if(dj >= max){
                    max = dj;
                    swap = true;
                    idx = j;
                }
            }
            if(swap)
                return swap(i,idx,digits);
        }
        return num;

    }
    int swap(int i , int j , char[] ds){
        char tmp = ds[i];
        ds[i] = ds[j];
        ds[j] = tmp;
        return Integer.parseInt(new String(ds));
    }

    public static void main(String[] args) {
        int num = 98368;
        MaximumNumberAfterSwap m = new MaximumNumberAfterSwap();
        System.out.println(m.maximumSwap(num));
    }
}
