package solutions.ArraysAndNumbersProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumArea {
    int M = 1000000007;
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        // if(h==0 || w == 0)return 0;
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        Piece piece = new Piece(0,0,w,h);
        int area = piece.area;
        ArrayList<Piece> parts = new ArrayList<>();
        parts.add(piece);
        for(int hCut : hCuts){
            int n = parts.size();
            for(int i = 0 ;  i < n ;i++){
                Piece p = parts.get(i);
                Piece cut = p.hCut(hCut);
                if(cut != p){
                    parts.add(cut);
                    area = Math.max(cut.area , p.area);
                }
            }
        }
        for(int v : vCuts){
            int n = parts.size();
            for(int i = 0 ;  i < n ;i++){
                Piece p = parts.get(i);
                Piece cut = p.vCut(v);
                if(cut != p){
                    parts.add(cut);
                    area = Math.max(cut.area,p.area);
                }
            }
        }
        return area;
    }
    class Piece{
        public int area;
        int x1,x2,y1,y2;
        Piece(int x1,int y1,int x2,int y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            calcArea();
        }
        Piece vCut(int v){
            if(v <= x1 || v >= x2)
                return this;
            Piece part = new Piece(x1,v,y1,y2);
            this.x1 = v;
            calcArea();
            return part;

        }
        Piece hCut(int h){
            if(h <= y1 || h >= y2)
                return this;
            Piece part = new Piece(x1,x2,y1,h);
            this.y1 = h;
            calcArea();
            return part;
        }
        void calcArea(){
            int width = (x2-x1);
            int height = (y2-y1);
            this.area = ((width % M) * (height%M)) %M;
        }

    }

    public static void main(String[] args) {
        int h = 4 , w = 5;
        int[] vcuts = {1,3};
        int[] hcuts = {1,2,4};
        MaximumArea m = new MaximumArea();
        int area = m.maxArea(h,w,hcuts,vcuts);
        System.out.println(area);
    }
}
