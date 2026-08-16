import java.util.*;

class Solution {
    static String[] arr={"A", "E", "I", "O", "U"};
    static int cnt=1;
    
    public int solution(String word) {
        int answer = 0;
        answer=dfs(word, 0, "");
        return answer;
    }
    
    public int dfs(String s, int depth, String str){
        if(depth==5){
            return -1;
        }else{
            for(int i=0; i<5; i++){
                if(s.equals(str+arr[i])){
                    return cnt;
                }
                cnt++;
               int result=dfs(s, depth+1, str+arr[i]);
                if(result!=-1) return cnt;
            }
        }
        return -1;
    }
}