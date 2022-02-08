package solutions;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        int openCount=0,closeCount=0;
        for(char c : chars){
            if(c == ')')
                closeCount++;
        }
        int remainClose = closeCount;
        int takenClose = 0;
        int takenOpen = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : chars){
            if(c == '(' ){
                if (takenOpen < remainClose + takenClose) {
                    sb.append(c);
                    takenOpen++;
                }
            }
            else if(c == ')'){
                remainClose--;
                if(takenOpen > takenClose){
                    sb.append(c);
                    takenClose++;
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
