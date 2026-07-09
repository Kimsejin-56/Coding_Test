class Solution {
    boolean solution(String s) {
        int cnt=0;

        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            
            if(c=='p') cnt++;
            else if(c=='y') cnt--;
        }
        
        return cnt==0;
    }
}