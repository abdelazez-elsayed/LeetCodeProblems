class Atoi {
    public int myAtoi(String s) {
        int sign=1;
        char c;
        int n = s.length();
        long result=0;
        int i=0;
        while(i<n && s.charAt(i) == ' ')
            i++;
        
        if(i==n)return 0;
        if(s.charAt(i) == '-'){
            sign=-1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            sign=1;
            i++;
        }
        for(;i<n;i++){
            c= s.charAt(i);
             if(c >= 48 &&  c <= 57){
                result = (c-48)+(result * 10);
                if(result > Integer.MAX_VALUE){
                   return (sign==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
                   
                }
               
            }
            else
                return (int)result*sign;
            
            
        }
        return (int)result*sign;
    }
}