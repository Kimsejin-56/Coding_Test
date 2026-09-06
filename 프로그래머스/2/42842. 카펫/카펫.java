class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int col=brown/2-1;
        int row=0;
        
        while(col!=0){
            int rest=brown-col*2;
            row=rest/2+2;
            int y=0;
            for(int i=1; i<col-1; i++){
                for(int j=1; j<row-1; j++){
                    y++;
                }
            }
            
            if(y==yellow) break;
            col--;
        }
        
        answer[0]=col;
        answer[1]=row;
        
        return answer;
    }
}