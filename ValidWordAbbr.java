package solutions;

public class ValidWordAbbr {
    public boolean validWordAbbreviation(String word, String abbr) {
        // write your code here
        int i=0;
        int n = word.length();
        int m = abbr.length();
        int base = 0;
        for(int j=0; j< abbr.length(); j++){
            if(i >= word.length())
                return false;
            if(abbr.charAt(j) == word.charAt(i)){
                i++;
            }else if(Character.isDigit(abbr.charAt(j))){
                int digit = abbr.charAt(j) - '0';
                base = base*10 + digit;
                if(base == 0)
                    return false;
                if(j+1 < m && Character.isDigit(abbr.charAt(j+1))){
                    continue;
                }
                i += base;
                base = 0;

            }else{
                return false;
            }
        }
        return i == word.length();
    }
    public static void main(String[] args) {
        ValidWordAbbr v = new ValidWordAbbr();
        String w ="internationalization";
        String ab =  "i12iz4n";
        System.out.println(v.validWordAbbreviation(w,ab));
    }
}
