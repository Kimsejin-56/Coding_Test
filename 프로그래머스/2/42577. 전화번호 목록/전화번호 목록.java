import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map=new HashMap<>();
        
        for(String s : phone_book) map.put(s, s);
        
        for(int i=0; i<phone_book.length; i++){
            String s=phone_book[i];
            String str="";
            for(int j=0; j<s.length()-1; j++){
                str+=s.charAt(j);
                if(map.get(str)!=null) return false;
            }
        }
        
        return answer;
    }
}