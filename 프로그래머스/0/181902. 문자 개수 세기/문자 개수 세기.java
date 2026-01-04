class Solution {
    public int[] solution(String my_string) {
        int[] result=new int[52];
        int idx = 0;
        
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            
            for(char a='A'; a<='Z'; a++){
                if(a == c){
                    result[idx]++;
                }
                idx++;
            }
            
            for(char a='a'; a<='z'; a++){
                if(a == c){
                    result[idx]++;
                }
                idx++;
            }
            
            idx = 0;
        }
        
        return result;
    }
}