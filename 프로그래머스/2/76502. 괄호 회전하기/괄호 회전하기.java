import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len=s.length();
        
        for(int i=0; i<len; i++){
            if(isValid(s)) answer++;
            
            //왼쪽 회전
            String tmp="";
            for(int j=1; j<len; j++){
                tmp+=s.charAt(j);
            }
            tmp+=s.charAt(0);
            s=tmp;
        }
        
        return answer;
    }
    
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            }else if(stack.isEmpty()) return false;
            else if(c==')') {
                if(stack.pop()!='(') return false;
            }else if(c=='}') {
                if(stack.pop()!='{') return false;
            }else if(c==']') {
                if(stack.pop()!='[') return false;
            }
        }
        
        if(!stack.isEmpty()) return false;
        
        return true;
    }
}