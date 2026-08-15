import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map=new HashMap<>();
        Arrays.sort(phone_book);
        
        
        for(int i=0; i<phone_book.length-1; i++){
            String s=phone_book[i];
            String next=phone_book[i+1];
            
            int len=Math.min(s.length(), next.length());
            
            int cnt=len;
            for(int j=0; j<len; j++){
                if(s.charAt(j)==next.charAt(j)) cnt--;
            }
            
            if(cnt==0){
                answer=false;
                break;
            }
        }
        
        return answer;
    }
}