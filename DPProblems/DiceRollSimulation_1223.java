package solutions.DPProblems;

public class DiceRollSimulation_1223 {
    int N = 1000000007;
    int[] rollMax;
    Integer[][][] memo;
    public int dieSimulator(int n, int[] rollMax) {
        this.rollMax= rollMax;
        memo = new Integer[n+1][6][16];
        if(n == 1){
            int cnt=0;
            for(int i : rollMax){
                if(rollMax[i] == 0 )
                    continue;
                cnt++;
            }
            return cnt;
        }
        int ans = 0;
        for(int i=0; i<6; i++){
            int pos = dieSimulator(n-1,i , rollMax[i]-1)%N;
            ans += pos;
            ans %= N;
        }
        return ans;
    }
    public int dieSimulator(int n , int prvRoll , int remains){
        if(n == 1){
            int cnt=0;
            for(int i=0; i<6;i++){
                if(i== prvRoll && remains <= 0 )
                    continue;
                cnt++;
            }
            return cnt;
        }
        if(memo[n][prvRoll][remains] != null)
            return memo[n][prvRoll][remains];
        int ans = 0;
        for(int i=0; i<6; i++){
            int r = i == prvRoll ? remains : rollMax[i];
            if(r <= 0 )
                continue;

            int pos =  (dieSimulator(n-1,i , r-1)%N);
            ans += pos;
            ans %=N;
        }
        return memo[n][prvRoll][remains] = ans;
    }
    public static void main(String[] args) {
        int n = 3;
        int[] rollMax = {1,1,1,2,2,3};
        DiceRollSimulation_1223 d= new DiceRollSimulation_1223();
        System.out.println(d.dieSimulator(n,rollMax));
    }
}
