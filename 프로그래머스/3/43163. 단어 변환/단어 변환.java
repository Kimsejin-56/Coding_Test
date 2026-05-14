import java.util.*;

class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        visited=new boolean[words.length];
        
        dfs(0, target, begin, words);
        if(answer==Integer.MAX_VALUE) return 0;
        return answer;
    }
    
    public void dfs(int depth, String target, String begin, String[] words){
        if(begin.equals(target)){
            answer=Math.min(answer, depth);
        }
       
        for(int i=0; i<words.length; i++){
            String tmp=words[i];
            int len=begin.length();
            
            for(int j=0; j<tmp.length(); j++){
                if(begin.charAt(j)==tmp.charAt(j)) len--;
            }
            
            if(len==1 && !visited[i]){
                visited[i]=true;
                dfs(depth+1, target, tmp, words);
                visited[i]=false;
            }
        }
    }
}