import java.util.*;

class Solution {
    static String[] arr={"A", "E", "I", "O", "U"};
    static int cnt=1;
    static int answer;
    
    public int solution(String word) {
        answer = 0;
        
        dfs(word, 0, "");
        return answer;
    }
    
    public void dfs(String s, int depth, String str){
        if(depth==5){
            return;
        }else{
            for(int i=0; i<5; i++){
                if(s.equals(str+arr[i])){
                    answer=cnt;
                    return;
                }
                cnt++;
                dfs(s, depth+1, str+arr[i]);
            }
        }
    }
}