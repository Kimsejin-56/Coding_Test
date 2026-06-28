import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1
        answer=new_id.toLowerCase();
        
        //2
        for(int i=0; i<new_id.length(); i++){
            char c=new_id.charAt(i);
            if(!Character.isDigit(c) && !Character.isLetter(c)){
                if(c=='.' || c=='-' || c=='_') continue;
                answer=answer.replace(String.valueOf(c), "");
            }
        }

        //3
        int cnt=0;
        for(int i=0; i<answer.length(); i++){
            char c=answer.charAt(i);
            if(c=='.') cnt++;
            else {
                if(cnt>=2){
                    String str="";
                    for(int j=0; j<cnt; j++){
                        str+=".";
                    }
                    answer=answer.replace(str, ".");
                    i-=cnt-1;
                    cnt=0;
                }else cnt=0;
            }
        }
        
        if(cnt>=2){
            String str="";
            for(int j=0; j<cnt; j++){
                str+=".";
            }
            answer=answer.replace(str, ".");
        }
        
        //4
        if(answer.length()!=0){
            if(answer.charAt(0)=='.'){
                answer=answer.substring(1);
            }
        }
        
        if(answer.length()!=0){
            if(answer.charAt(answer.length()-1)=='.'){
                answer=answer.substring(0, answer.length()-1);
            }
        }
        
        //5
        if(answer.equals("")){
            answer+="a";
        }
        
        //6
        if(answer.length()>=16){
            answer=answer.substring(0, 15);
             if(answer.charAt(answer.length()-1)=='.'){
                answer=answer.substring(0, answer.length()-1);
            }
        }
        
        //7
        while(answer.length()<3){
            answer+=String.valueOf(answer.charAt(answer.length()-1));
        }
       
        return answer;
    }
}