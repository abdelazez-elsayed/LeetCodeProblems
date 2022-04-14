package solutions.StringsAndPatternsProblems;

import java.util.HashSet;
import java.util.Set;

public class tilesPerm {
    Set<String> explored;
    public int numTilePossibilities(String tiles) {
        explored = new HashSet<>();
        buildString(tiles," ");
        return explored.size()-1;

    }
    void buildString(String tiles,String prev){
        if(explored.contains(prev))
            return;

        explored.add(prev);
        StringBuilder sb = new StringBuilder(tiles);
        for(int i=0; i<tiles.length(); i++){
            char c= tiles.charAt(i);
            sb.deleteCharAt(i);
            String next = prev+c;
            buildString(sb.toString(),next);
            sb = new StringBuilder(tiles);
        }
    }
    public static void main(String[] args) {

        tilesPerm tilesPerm = new tilesPerm();
        tilesPerm.numTilePossibilities("AAB");
    }
}
