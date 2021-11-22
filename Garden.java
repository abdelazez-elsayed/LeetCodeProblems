package solutions;

import java.util.HashSet;
import java.util.Set;

public class Garden {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] sol = new int[n];
        Set<Integer>[] sol_sets = new HashSet[n];
        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            set.add(1);
            set.add(2);
            set.add(3);
            set.add(4);
            sol_sets[i] = set;

        }
        for(int i=0; i < n; i++){
            int flower=-1;
            for(Integer f : sol_sets[i]){
                flower =f;
                break;
            }
            sol[i] = flower;
            for(int j=0; j<n; j++){
                if(paths[j][0] == i+1 || paths[j][1] == i+1)
                    sol_sets[j].remove(flower);
            }
        }
        return sol;
    }
    public static void main(String[] arg){
        Garden g= new Garden();
        int[][] arr = {{1,2},{2,3},{3,1}};
       int[] sol =  g.gardenNoAdj(3,arr);
    }
}
