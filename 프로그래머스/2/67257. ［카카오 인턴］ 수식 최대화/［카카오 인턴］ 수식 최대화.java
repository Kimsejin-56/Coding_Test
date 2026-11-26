import java.util.*;

//8:41
class Solution {
    static String[] op={"*", "-", "+"};
    static List<Long> num;
    static List<String> ops;
    static long answer;
    
    public long solution(String expression) {
        answer = 0;
        num=new ArrayList<>();
        ops=new ArrayList<>();
        int idx=0;
        String str="";
        
        while(idx<expression.length()){
            if(Character.isDigit(expression.charAt(idx))){
                str+=expression.charAt(idx);
            }else{
                num.add(Long.parseLong(str));
                ops.add(String.valueOf(expression.charAt(idx)));
                str="";
            }
            idx++;
        }
        
        num.add(Long.parseLong(str));
        
        dfs(0, new String[3], new boolean[3], expression);
        
        return answer;
    }
    
    public void dfs(int depth, String[] arr, boolean[] visited, String ex){
        if(depth==3){
            answer=Math.max(answer, calc(arr, ex));
            return;
        }else{
            for(int i=0; i<3; i++){
                if(visited[i]) continue;
                visited[i]=true;
                arr[depth]=op[i];
                dfs(depth+1, arr, visited, ex);
                visited[i]=false;
            }
        }
    }
    
    public long calc(String[] arr, String ex){
        List<Long> nums=new ArrayList<>(num);
        List<String> operators=new ArrayList<>(ops);
        
        for(int i=0; i<3; i++){
            int idx=0;
            String op=arr[i];
            
            while(idx<operators.size()){
                if(op.equals(operators.get(idx))){
                    long n=simpleCalc(nums.get(idx), nums.get(idx+1), op);
                    
                    operators.remove(idx);
                    nums.remove(idx+1);
                    nums.remove(idx);
                    nums.add(idx, n);
                }else idx++;
            }
        }
        
        return Math.abs(nums.get(0));
    }
    
    public long simpleCalc(long n1, long n2, String op){
        if(op.equals("*")) return n1*n2;
        if(op.equals("-")) return n1-n2;
        return n1+n2;
    }
}