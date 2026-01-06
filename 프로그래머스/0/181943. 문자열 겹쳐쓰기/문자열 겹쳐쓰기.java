class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        for(int i=0; i<s; i++){
            answer += my_string.charAt(i);        
        }
        
        answer += overwrite_string;
       
        int idx = answer.length();
        int diff = my_string.length()-answer.length();
        
        if(my_string.length() > answer.length()){
            for(int i=0; i<diff; i++){
                answer += my_string.charAt(idx++);
            }
        }
        
        return answer;
    }
}