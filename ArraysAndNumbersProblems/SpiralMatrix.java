package solutions.ArraysAndNumbersProblems;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();

        int l = 0, r = matrix[0].length, t = 0, b = matrix.length;
        while (l < r && t < b) {
            for (int i = l; i < r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i < b; i++) {
                list.add(matrix[i][r - 1]);
            }
            r--;
            if (t < b) {
                for (int i = r - 1; i >= l; i--) {
                    list.add(matrix[b - 1][i]);
                }
                b--;
            }
            if (l < r) {
                for (int i = b - 1; i >= t; i--) {
                    list.add(matrix[i][l]);
                }
                l++;
            }

        }
        return list;
    }
}
