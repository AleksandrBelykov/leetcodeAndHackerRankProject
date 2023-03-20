package floodFill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

//        int[][] image = {{0,0,0},{0,0,0},{0,0,0}};
//        int sr = 1, sc = 1, color = 0;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) {
            return image;
        }

        int initColor = image[sr][sc];
        int[][] answer = image;
        int[] rowNeighbours = {-1,1,0,0};
        int[] colNeighbours = {0,0,1,-1};

        recursionFunc(image, sr, sc, color, initColor, rowNeighbours, colNeighbours, answer);
        return answer;
    }

    private static void recursionFunc(int[][] image, int sr, int sc, int color, int initColor, int[] rowNeighbours,  int[] colNeighbours, int[][] answer){
        answer[sr][sc] = color;
        int numOfRows = image.length;
        int numOfColumns = image[0].length;

        for (int direction = 0; direction<4; direction++){
            int nrow = sr+rowNeighbours[direction];
            int ncol = sc+colNeighbours[direction];

            if (nrow >= 0 && nrow < numOfRows && ncol >= 0 && ncol < numOfColumns && image[nrow][ncol] == initColor && answer[nrow][ncol] != color){
                recursionFunc(image, nrow, ncol, color, initColor, rowNeighbours, colNeighbours, answer);
            }
        }
    }
}
