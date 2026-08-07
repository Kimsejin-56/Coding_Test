import java.sql.SQLOutput;
import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int k=0; k<arr2[0].length; k++){
            for(int i=0; i<arr1.length; i++){
                int total=0;

                for(int j=0; j<arr1[i].length; j++){
                    total+=arr1[i][j]*arr2[j][k];
                }
                answer[i][k]=total;
            }
        }

        return answer;
    }
}