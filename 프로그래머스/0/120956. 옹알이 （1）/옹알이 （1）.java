import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] temp = babbling;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<arr.length; j++){
                temp[i] = temp[i].replace(arr[j], " ");
            }
        }
        
        for(int i=0; i<temp.length; i++){
            temp[i]=temp[i].replace(" ", "");
        }
        
        
        for(int i=0; i<temp.length; i++){
            if(temp[i].equals("")) answer++;
        }
       

        return answer;
    }
}
