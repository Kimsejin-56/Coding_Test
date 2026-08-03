import java.util.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len=absolutes.length;
        for(int i=0; i<len; i++){
            int num=absolutes[i];

            if(signs[i]) answer+=num;
            else answer-=num;
        }
            return answer;
    }
}