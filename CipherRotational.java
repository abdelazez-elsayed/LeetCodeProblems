package solutions;

public class CipherRotational {
    static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder br = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(Character.isDigit(c)){
                int n = Character.getNumericValue(c);
                n = (n+ rotationFactor) %10;
                br.append(n);
            }
            else if(Character.isLowerCase(c)){
                int n = c;
                n -= 97;
                n += rotationFactor;
                n = n%26;
                n += 97;
                br.append((char) n);
            }else if(Character.isUpperCase(c)){
                int n = c;
                n -= 65;
                n += rotationFactor;
                n = n%26;
                n += 65;
                br.append((char) n);
            }else
                br.append(c);
        }
        return br.toString();
    }
    public static void main(String[] as){
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        System.out.println(output_1);

    }
}
