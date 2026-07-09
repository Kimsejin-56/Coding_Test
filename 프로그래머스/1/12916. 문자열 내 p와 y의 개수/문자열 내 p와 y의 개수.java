class Solution {
    boolean solution(String s) {
        int cntP=0, cntY=0;
        s=s.toLowerCase();

        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            
            if(c=='p') cntP++;
            else if(c=='y') cntY++;
        }
        
        if(cntP!=cntY) return false;
        
        return true;
    }
}