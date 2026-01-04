import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        
        for(int i=0; i<a.length(); i++){
            char c = a.charAt(i);
            
            for(char j='a'; j<='z'; j++){
                if(c == j){
                    answer += String.valueOf(c).toUpperCase();
                }
            }
            
            for(char j='A'; j<='Z'; j++){
                if(c == j){
                    answer += String.valueOf(c).toLowerCase();
                }
            }
        }

        
        System.out.println(answer);
    }
}