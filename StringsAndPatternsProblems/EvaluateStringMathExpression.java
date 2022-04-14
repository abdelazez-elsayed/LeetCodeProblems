package solutions.StringsAndPatternsProblems;

public class EvaluateStringMathExpression {
    int evaluate(String s){
        String[] mults = s.split("[+-]");
        int res=0;
        boolean[] add = new boolean[s.length()];
        int i=0;
        for(char c : s.toCharArray()){
            if(c == '+' ){
                add[i++] = true;
            }else if(c == '-'){
                add[i++] = false;
            }
        }
        res = evaluateMult(mults[0]);
        for(int j=0;j<i; j++){
            if(add[j]) {
                res += evaluateMult(mults[j+1]);
            }else{
                res -= evaluateMult(mults[j+1]);
            }
        }
        return res;
    }
    int evaluateMult(String s){
        try {
            return Integer.parseInt(s.trim());
        }catch (Exception e){
            boolean[] mult = new boolean[s.length()];
            String[] vals = s.split("[*/]");
            int i=0;
            for(char c : s.toCharArray()){
                if(c == '*' ){
                    mult[i++] = true;
                }else if(c == '/'){
                    mult[i++] = false;
                }
            }
            int acc=Integer.parseInt(vals[0].trim());
            for(int j=0;j<i; j++){
                if(mult[j]) {
                    acc *= Integer.parseInt(vals[j+1].trim());
                }else{
                    acc /= Integer.parseInt(vals[j+1].trim());
                }
            }
            return acc;
        }
    }

    public static void main(String[] args) {
        EvaluateStringMathExpression e = new EvaluateStringMathExpression();
        System.out.println(e.evaluate("3/2"));
    }
}
