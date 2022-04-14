package solutions;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i < n1; i++ ){
            freq1[s1.charAt(i) - 'a']++;
        }
        int needed = n1;
        int l = 0;
        for(int r=0; r<n2; r++){
            char c2 = s2.charAt(r);
            if(freq1[c2-'a'] > freq2[c2-'a']){
                needed--;
            }
            freq2[c2-'a']++;
            while(needed == 0 && l < r){
                char cl = s2.charAt(l);
                if(freq2[cl-'a'] == freq1[cl-'a'])
                    break;
                freq2[cl - 'a']--;
                l++;

            }
            if(isEqual(freq1,freq2))
                return true;
        }
        return false;

    }
    private boolean isEqual(int[] a , int[] b){
        for(int i=0; i < a.length; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        PermutationInString p = new PermutationInString();
        boolean r = p.checkInclusion(s1,s2);
        System.out.println(r);
    }
}
