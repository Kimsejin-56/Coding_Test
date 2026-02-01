import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};
        
        //연속되는 발음만 제거
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].contains("ayaaya") ||
              babbling[i].contains("yeye") ||
              babbling[i].contains("woowoo") ||
              babbling[i].contains("mama")){
                babbling[i]="x";
            }
        }
        
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<arr.length; j++){
               babbling[i] = babbling[i].replace(arr[j], " ");
            }
        }
        
        System.out.println(Arrays.toString(babbling));
        
        for(int i=0; i<babbling.length; i++){
            babbling[i]=babbling[i].replace(" ", "");
        }
        
        System.out.println(Arrays.toString(babbling));
        
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].equals("")) answer++;
        }
       

        return answer;
    }
}
