package solutions;

class Atoi {
    public int myAtoi(String s) {
        int sign = 0;
        s = s.trim();
        if(s.length() == 0)
            return 0;
        if(s.charAt(0) == '-')
            sign = -1;
        else if(s.charAt(0) == '+')
            sign = 1;
        int n = s.length();
        int start;
        start = sign == -1 ? 0 : 1 ;
        int ans = 0;

        int limit = Integer.MAX_VALUE/10;
        for(int i = start ; i < n ; i++){
            if(!Character.isDigit(s.charAt(i)))
                break;
            int dig = s.charAt(i) - '0';
            if(ans > limit || ans == limit && dig > 7){
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans*10 + dig;
        }
        return sign == -1 ?  -ans :  ans;
    }

}