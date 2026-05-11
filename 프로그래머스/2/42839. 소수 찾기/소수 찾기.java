import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        set=new HashSet<>();
        visited=new boolean[numbers.length()];
        int[] number=new int[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            number[i]=Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        
        dfs(number, 0, "");
        return set.size();
    }
    
    public void dfs(int[] number, int depth, String str){
        if(depth!=0 && depth<=number.length){
            int n=Integer.parseInt(str);
            boolean pass=false;
            for(int i=2; i<=Math.sqrt(n); i++){
                if(n%i==0){
                    pass=true;
                    break;
                }
            }
            if(!pass) {
                if(n!=0 && n!=1) set.add(n);
            }
            if(depth==number.length) return;
        }
            
        for(int i=0; i<number.length; i++){
            if(!visited[i]){
                String tmp=str;
                tmp+=number[i];
                visited[i]=true;
                dfs(number, depth+1, tmp);
                visited[i]=false;
            }
        }
    }
}