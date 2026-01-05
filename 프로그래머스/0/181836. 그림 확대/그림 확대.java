class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int cnt = 0;
        
        for(int i=0; i<picture.length; i++){
            String part = picture[i];
            String temp = "";
            
            
            for(int j=0; j<part.length(); j++){
                for(int l=0; l<k; l++){
                    temp += part.charAt(j);
                }
            }
        
            for(int j=0; j<k; j++){
                answer[cnt++] = temp;
            }
        }
        
        return answer;
    }
}