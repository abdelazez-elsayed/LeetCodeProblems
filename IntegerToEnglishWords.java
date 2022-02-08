package solutions;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String ans = "";
        if( num >= 1e9){
            int bilions = (int) (num / 1e9);
            num %= 1e9;
            ans += (getNumUpTo99(bilions)+" Billion ");
        }if(num >= 1e6){
            int millions = (int) (num / 1e6);
            num %= 1e6;
            ans += (getNum999(millions)+" Million ");
        }if(num >= 1e3){
            int thousands =  (num / 1000);
            num %= 1000;
            ans += getNum999(thousands)+" Thousand ";
        }
        ans += getNum999(num);
        return ans.trim();
    }
    String getNum999(int n){
        if(n < 100)
            return getNumUpTo99(n);
        else{
            int hundreds = n/100;
            String hundredS = getNumUpTo99(hundreds)+" Hundred";
            String r = getNumUpTo99(n%100);
            return (hundredS+" "+r).trim();
        }
    }
    String getNumUpTo99(int n){
        if(n > 99)
            throw new IllegalArgumentException("Num > 99");

        int tenth = n/10;
        int ones = n%10;

        String tenth_string = "";
        String ones_string = "";
        switch(tenth){
            case 1 :
                switch(n){
                    case 10 :
                        tenth_string = "Ten";
                        break;
                    case 11 :
                        tenth_string = "Eleven";
                        break;
                    case 12:
                        tenth_string = "Twelve";
                        break;
                    case 13:
                        tenth_string = "Thirteen";
                        break;
                    case 14:
                        tenth_string = "Fourteen";
                        break;
                    case 15:
                        tenth_string = "Fifteen";
                        break;
                    case 16:
                        tenth_string = "Sixteen";
                        break;
                    case 17:
                        tenth_string = "Seventeen";
                        break;
                    case 18:
                        tenth_string = "Eighteen";
                        break;
                    case 19:
                        tenth_string = "Nineteen";
                        break;

                }
                break;
            case 2:
                tenth_string = "Twenty";
                break;
            case 3:
                tenth_string = "Thirty";
                break;
            case 4:
                tenth_string = "Forty";
                break;
            case 5:
                tenth_string = "Fifty";
                break;
            case 6:
                tenth_string = "Sixty";
                break;
            case 7 :
                tenth_string = "Seventy";
                break;
            case 8 :
                tenth_string = "Eighty";
                break;
            case 9:
                tenth_string = "Ninety";
                break;
            default:
                tenth_string ="";
        }
        if(tenth != 1){
            switch(ones){
                case 1:
                    ones_string = "One";
                    break;
                case 2:
                    ones_string = "Two";
                    break;
                case 3:
                    ones_string = "Three";
                    break;
                case 4:
                    ones_string = "Four";
                    break;
                case 5:
                    ones_string = "Five";
                    break;
                case 6:
                    ones_string = "Six";
                    break;
                case 7:
                    ones_string = "Seven";
                    break;
                case 8:
                    ones_string = "Eight";
                    break;
                case 9:
                    ones_string = "Nine";
                    break;
                default:
                    ones_string = "";
            }
        }
        return (tenth_string +" "+ ones_string).trim();
    }
    public static void main(String[] args) {
        int num = 2000000000;
        IntegerToEnglishWords i = new IntegerToEnglishWords();
        System.out.println(i.numberToWords(num));
    }
}
