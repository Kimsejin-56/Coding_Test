import java.util.*;

class Solution {
    static char[] op={'*', '+', '-'};
    static boolean[] visited;
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        visited=new boolean[3];
        dfs(0, new char[3], expression);
        return answer;
    }
    
    public void dfs(int depth, char[] arr, String ex){
        if(depth==3){
             answer=Math.max(answer, Math.abs(calc(arr, ex)));
        }else{
            for(int i=0; i<3; i++){
                if(visited[i]) continue;
                arr[depth]=op[i];
                visited[i]=true;
                dfs(depth+1, arr, ex);
                visited[i]=false;
            }
        }
    }
    
    public long calc(char[] arr, String ex){
        String num="";
        List<Long> nums=new ArrayList<>();
        List<Character> ops=new ArrayList<>();
        
        for(int i=0; i<ex.length(); i++){
            if(Character.isDigit(ex.charAt(i))){
                num+=String.valueOf(ex.charAt(i)); 
            }else {
                nums.add(Long.parseLong(num));
                num="";
                ops.add(ex.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));
        
        for(int i=0; i<3; i++){
            char oper=arr[i];
            for(int j=0; j<ops.size(); j++){
                if(oper==ops.get(j)){
                    long n=0;
                    long n1=nums.get(j);
                    long n2=nums.get(j+1);
                    
                    if(oper=='*') n=n1*n2;
                    else if(oper=='+') n=n1+n2;
                    else if(oper=='-') n=n1-n2;
                    
                    nums.remove(j+1);
                    nums.remove(j);
                    
                    nums.add(j, n);
                    ops.remove(j);
                    j--;
                }
            }
        }
        
        return nums.get(0);
    }
    
}