package solutions.StringsAndPatternsProblems;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        int zigzagLenghth =numRows+numRows-2;
        if(numRows==1)
            return s;
        int n = s.length();
        int zigzagChuncks= n/zigzagLenghth;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<rows.length;i++)
            rows[i] = new StringBuilder();
        int j;
        for(int i=0; i<zigzagChuncks;i++){
            j = i*zigzagLenghth+zigzagLenghth/2;
            int l=j-1;
            int r=j+1;
            rows[numRows-1].append(s.charAt(j));
            int k=numRows-2;
            while (k>0){
                rows[k].append(s.charAt(l));
                rows[k].append(s.charAt(r));
                l--;
                r++;
                k--;
            }
            rows[0].append(s.charAt(l));
        }
        if(n%zigzagLenghth != 0 ){
            int i;
            j=(zigzagLenghth)*zigzagChuncks;
            int k = Math.min(numRows,n-j);
            for(i=0;i<k;i++){
                rows[i].append(s.charAt(j++));
            }
            i = numRows-2;
            while (j<n){
                rows[i--].append(s.charAt(j++));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }

        return ret.toString();
    }
}
