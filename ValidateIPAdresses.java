package solutions;

public class ValidateIPAdresses {
    public String validIPAddress(String queryIP) {
        String wrong = "Neither";
        String ipv4 = "IPv4";
        String ipv6 = "IPv6";
        String[] Bytes = queryIP.split("\\.");
        //If split returns 4 --> it might be IPv4
        if(Bytes.length == 4){
            int dotCount=0;
            for(char c : queryIP.toCharArray()){
                if(c == '.')
                    dotCount++;
            }
            if(dotCount != 3)return wrong;
            for(String b : Bytes){
                if(b.length() > 3)
                    return wrong;
                for(char c : b.toCharArray()){
                    if(Character.isDigit(c) && c != '0')
                        break;
                    else if(c == '0' && b.length() == 1)
                        break;
                    else
                        return wrong;
                }
                try{
                    int i = Integer.parseInt(b);
                    if( i < 0 || i > 255)
                        return wrong;
                }catch (Exception e){
                    return wrong;
                }
            }
            return ipv4;
        }
        String[] hexas = queryIP.split(":");
        if(hexas.length == 8){
            int semiCount=0;
            for(char c : queryIP.toCharArray()){
                if(c == ':')
                    semiCount++;
            }
            if(semiCount != 7)return wrong;
            for(String twoBytes : hexas){
                if(twoBytes.length() > 4)
                    return wrong;
                try{
                    int i = Integer.parseInt(twoBytes,16);
                    if(i < 0 || i > 65535 )
                        return wrong;
                }catch (Exception e){
                    return wrong;
                }
            }
            return ipv6;
        }
        return wrong;
    }

    public static void main(String[] args) {
        ValidateIPAdresses v = new ValidateIPAdresses();
        String ans = v.validIPAddress("192.0.0.1");
        System.out.println(ans);
    }
}
