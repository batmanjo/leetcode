package daily;

import java.util.Arrays;
import java.util.Comparator;

public class No3000 {
    class Model implements Comparable<Model>{
        public int length;
        public int index;

        @Override
        public int compareTo(Model o) {
            return length - o.length;
        }
    }
    public int areaOfMaxDiagonal(int[][] dimensions) {
        Model[] models = new Model[dimensions.length];
        for (int i = 0; i < dimensions.length; i++) {
            models[i] = new Model();
            models[i].index = i;
            models[i].length = dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1];
        }
        Arrays.sort(models);
        int area = 0;
        int maxLength = models[models.length - 1].length;

        for (int i = models.length - 1; i > -1; i--) {
            if(models[i].length < maxLength) {
                break;
            }else{
                int tempArea = dimensions[models[i].index][0] * dimensions[models[i].index][1];
                if(tempArea > area) {
                    area = tempArea;
                }
            }
        }
        return area;
    }

// official solution
    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int maxDiaSq = 0;
            int maxArea = 0;
            for (int[] dim : dimensions) {
                int l = dim[0];
                int w = dim[1];
                int diaSq = l * l + w * w;
                int area = l * w;
                if (diaSq > maxDiaSq) {
                    maxDiaSq = diaSq;
                    maxArea = area;
                } else if (diaSq == maxDiaSq) {
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }
}
