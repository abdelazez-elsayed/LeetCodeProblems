package solutions.ArraysAndNumbersProblems;

import Datastructure.Point;
import Datastructure.Utils;

import java.util.*;

public class MaxPointsOnALine_149 {
    public int maxPoints(int[][] points) {

        int n = points.length;
        if(n < 3)
            return n;
        int ans = 0;
        Map<Line,Set<int[]>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.clear();
            for(int j = 0; j<n; j++){
                if(i==j)
                    continue;
                Line line = new Line(points[i] , points[j]);
                if(map.containsKey(line))
                {
                    map.get(line).add(points[i]);
                    map.get(line).add(points[j]);
                }
                else {
                    map.put(line,new HashSet<>());
                    map.get(line).add(points[i]);
                    map.get(line).add(points[j]);
                }
                ans = Math.max(ans , map.get(line).size());
            }

        }


        return ans;
    }


    public int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b%a, a);
    }
    class Line{
        int slopeN , slopeD, intrcN , intrcD , x;
        public Line(int[] p1 , int[] p2){
            this.slopeN = p2[1] - p1[1];
            this.slopeD = p2[0] - p1[0];
            this.x = p1[0];
            intrcN = p1[0] * (slopeD) - p1[1] * (slopeN);
            intrcD = slopeD;

            int slopeGCD = gcd(slopeN , slopeD);
            if(slopeGCD != 0) {
                slopeN /= slopeGCD;
                slopeD /= slopeGCD;
            }

            int intrcGCD = gcd(intrcN , intrcD);
            if(intrcGCD != 0) {
                intrcN /= intrcGCD;
                intrcD /= intrcGCD;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return slopeN == line.slopeN &&
                    slopeD == line.slopeD &&
                    intrcN == line.intrcN &&
                    intrcD == line.intrcD;
        }

        @Override
        public int hashCode() {
            if(slopeD == 0)
                return Objects.hash(Integer.MAX_VALUE , x);
            return Objects.hash(slopeN, slopeD, intrcN, intrcD);
        }
    }
    public static void main(String[] args) {
        String weird = "[[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3],[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15],[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2],[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14],[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11],[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1],[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4],[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20],[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12],[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3],[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12],[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7],[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6],[-11,-8]]";
        String norm  = "[[-8,-3],[7,-3],[15,12]]";
        int[][] points = Utils.parse2DintArray(weird);
        MaxPointsOnALine_149 m = new MaxPointsOnALine_149();
        int res = m.maxPoints(points);
        System.out.println(res);
    }
}
