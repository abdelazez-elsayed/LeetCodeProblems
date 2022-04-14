package solutions.ArraysAndNumbersProblems;

public class InsertFive {
    public int insertFive(int a) {
        // write your code here
        if(a==0)
            return 5;
        if(a>0){
            int n=a;
            int res=1;
            while(n>0){
                res = res*10;
                n = n/10;
            }
            while(res>1){
                n=a;
                int digit = (n /(res/10))%10;
                int left = n / res;
                System.out.println("Left = "+left);
                System.out.println("Digit = "+digit);
                if(digit < 5){
                    int rest = a % res;
                    int right = 5 * res + rest;
                    left = left * (res*10);
                    return left+right;
                }else{
                    res = res/10;
                }
            }
            return res + a;
        }
        a = a*10;
        a-=5;
        return a;
    }

    public static void main(String[] args) {
        InsertFive f = new InsertFive();
        int sol = f.insertFive(99234);
        System.out.println("Sol = "+sol);
    }
}
