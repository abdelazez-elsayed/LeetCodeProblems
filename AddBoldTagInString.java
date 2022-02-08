package solutions;

public class AddBoldTagInString {
    public String addBoldTag(String s, String[] dict) {
        // write your code here
        int n = s.length();
        boolean[] bolded = new boolean[n];
        int end=0;
        for(int i=0; i<n; i++){

            for(String word : dict){
                if(s.startsWith(word,i))
                    end = Math.max(end,word.length()+i);
            }
            if(i < end)
                bolded[i] = true;
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            if(bolded[i] && (i==0 || !bolded[i-1]))
                sb.append("<b>");
            else if(!bolded[i] && ( i>0 && bolded[i-1]))
                sb.append("</b>");
            sb.append(s.charAt(i));
        }
        if(bolded[n-1])
            sb.append("</b>");
        return sb.toString();

    }
}
