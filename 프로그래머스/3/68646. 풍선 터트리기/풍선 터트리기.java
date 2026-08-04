import java.util.*;

//[-16,27,65,-2,58,-92,-71,-68,-61,-33]
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int left=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;

        for(int i=0; i<a.length; i++){
            if(left>a[i]){
                left=a[i];
                answer++;
            }
        }

        for(int i=a.length-1; i>=0; i--){
            if(right>a[i]){
                right=a[i];
                answer++;
            }
        }
        return answer-1;
    }
}