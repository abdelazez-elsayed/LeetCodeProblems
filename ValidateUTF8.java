package solutions;

public class ValidateUTF8 {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        for(int i=0; i<n;){
            if(data[i] <= 127) // 0xxx xxx
                i++;
            //110x xxxx
            else if(data[i] >= 192 && data[i] <= 223){
                if(i+1 >= n) // check remaining
                    return false;
                // 10xx xxxx
                if(data[i+1] >= 128 &&  data[i+1] <= 191)
                    i = i+2;
                else
                    return false;
            //1110 xxxx
            }else if( data[i] >= 224 && data[i] <= 239){
                if(i+2 >= n) // check remaining
                    return false;
                for(int j=i+1; j<i+3; j++){
                    // 10xx xxxx
                    if(data[j] >= 128 &&  data[j] <= 191)
                        continue;
                    return false;
                }
                i = i+3;
             //1111 0xxx
            }else if(data[i] >= 240 && data[i] <= 247){
                if(i+3 >= n)
                    return false;
                // 10xx xxxx
                for(int j=i+1; j<i+4; j++){
                    if(data[j] >= 128 &&  data[j] <= 191)
                        continue;
                    return false;
                }
                i = i+4;
            }else // data[i] == 255
                return false;
        }
        return true;
    }
}
