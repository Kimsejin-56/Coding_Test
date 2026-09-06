class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int col=brown/2-1;
        int row=0;
        
        while(col!=0){
            int rest=brown-col*2;
            row=rest/2+2;
            
            if(((col-2)*(row-2))==yellow) break;
            col--;
        }
        
        answer[0]=col;
        answer[1]=row;
        
        return answer;
    }
}