package solutions.StringsAndPatternsProblems;

public class VerifyAllienDictionary {
    public boolean isAlienSorted(String[] words, String order) {

        int[] order_map = new int[26];
        for(int i =0; i< order.length(); i++){
            order_map[order.charAt(i) - 'a'] = i;
        }
        for(int i=0; i<words.length-1; i++){
            boolean res = compareTwoWords(words[i],words[i+1],order_map);
            if(!res)
                return false;
        }
        return true;
    }

    boolean compareTwoWords(String w1,String w2,int[] order_map){
        int n1 = w1.length();
        int n2 = w2.length();
        for(int i=0; i<n1; i++){
            if( i >= n2) return false;

            if(w1.charAt(i) != w2.charAt(i)){
                int w1i = w1.charAt(i) - 'a';
                int w2i = w2.charAt(i) - 'a';
                return order_map[w2i] >= order_map[w1i];
            }
        }
        return true;
    }
}
