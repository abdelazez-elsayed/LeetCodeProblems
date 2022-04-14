package solutions.StringsAndPatternsProblems;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        char[] cs = s.toCharArray();
        for(char c : cs){
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int idx = findMost(freq,-1);
            if(n == 1){
                char c = (char) (idx + 'a');
                sb.append(c);
                return sb.toString();
            }
            int secnd = findMost(freq,idx);
            if(secnd == -1)
                return "";
            char f = (char) (idx + 'a');
            char se = (char) (secnd + 'a');
            sb.append(f).append(se);
            n -= 2;
            freq[idx]--;
            freq[secnd]--;
        }
        return sb.toString();
    }
    int findMost(int[] freq , int expt){
        int ans = -1;
        int most = 0;
        for(int i = 0; i < 26; i++){
            if(i != expt && freq[i] > 0 && freq[i] > most){
                ans = i;
                most = freq[i];
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String  s = "aab";
        ReorganizeString r = new ReorganizeString();
        String a  = r.reorganizeString(s);
        System.out.println(a);
    }
}
