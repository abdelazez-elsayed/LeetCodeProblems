package solutions.StringsAndPatternsProblems;

public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int n1 = vs1.length , n2 = vs2.length;
        for(int i=0; i < n1 || i<n2 ; i++){
            int j1 = 0 , j2=0;
            String v1 = i < n1 ? vs1[i] : "";
            String v2 = i < n2 ? vs2[i] : "";
            int ns1 = v1.length()  , ns2 = v2.length();
            while(j1 < ns1 && v1.charAt(j1) == '0')
                j1++;
            while(j2 < ns2 && v2.charAt(j2) == '0')
                j2++;
            while(j1 < ns1 && j2 < ns2 && v1.charAt(j1) == v2.charAt(j2)){
                j1++;
                j2++;
            }
            if(j1 == ns1 && j2 == ns2)
                continue;
            if(ns1 - j1  > ns2 - j2)
                return 1;
            else if(ns2 - j2 > ns1 - j1)
                return -1;
            if(v1.charAt(j1) > v2.charAt(j2))
                return 1;
            else if(v2.charAt(j2) > v1.charAt(j1))
                return -1;

        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "1.2";
        String v2 = "1.10";
        CompareVersionNumbers_165 c = new CompareVersionNumbers_165();
        int res = c.compareVersion(v1,v2);
        System.out.println(res);
    }
}
