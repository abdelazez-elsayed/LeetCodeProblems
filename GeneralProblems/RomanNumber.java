package solutions.GeneralProblems;

import java.util.Hashtable;
import java.util.Map;

public class RomanNumber {
    Hashtable<Integer,Character> look_up  = new Hashtable<>();
    int[] bases = {1000,100,10,1};
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        look_up.put(1000,'M');
        look_up.put(500,'D');
        look_up.put(100,'C');
        look_up.put(50,'L');
        look_up.put(10,'X');
        look_up.put(5,'V');
        look_up.put(1,'I');
        while (num >= 1000){
            num -= 1000;
            builder.append(look_up.get(1000));
        }
        int i=0;

        while (i<bases.length-1) {
            int basesDiff = bases[i] - bases[i + 1];
            int BasesOver2 = bases[i] / 2;
            if (num >= basesDiff) {
                num -= basesDiff;
                builder.append(look_up.get(bases[i+1])).append(look_up.get(bases[i]));
            } else if (num >= BasesOver2) {
                num -= BasesOver2;
                builder.append(look_up.get(BasesOver2));
                while (num >= BasesOver2) {
                    num -= bases[i + 1];
                    builder.append("I");
                }
            }
            int BaseOver2_nextbase = BasesOver2 - bases[i + 1];
            if (num >= BaseOver2_nextbase) {
                num -= BaseOver2_nextbase;
                builder.append(look_up.get(bases[i+1])).append(look_up.get(BasesOver2));
            } else if (num >= bases[i + 1]) {
                builder.append(look_up.get(bases[i + 1]));
                num -= bases[i + 1];
                while (num >= bases[i + 1]) {
                    num -= bases[i + 1];
                    builder.append(look_up.get(bases[i+1]));
                }
            }
            i++;
        }



        return builder.toString();
    }

}
