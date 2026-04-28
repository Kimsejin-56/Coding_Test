import java.util.*;

class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int depth){
        if(depth == numbers.length){
            if(sum==target) answer++;
            return;
        }else {
            dfs(numbers, target, sum+numbers[depth], depth+1); 
            dfs(numbers, target, sum-numbers[depth], depth+1); 
        }
    }
}