import java.util.*;

class Solution {
    static Map<String, int[]> dir;
    static int[] answer;
    static int[][] board;
    static int h, w;
    
    public int[] solution(String[] park, String[] routes) {
        answer = new int[2];
        dir=new HashMap<>();
        h=park.length;
        w=park[0].length();
        board=new int[h][w];
        
        dir.put("S", new int[]{1,0});
        dir.put("E", new int[]{0,1});
        dir.put("N", new int[]{-1,0});
        dir.put("W", new int[]{0,-1});
        
        for(int i=0; i<h; i++){
            String tmp=park[i];
            for(int j=0; j<w; j++){
                if(tmp.charAt(j)=='X') board[i][j]=1;
                else if(tmp.charAt(j)=='S'){
                    answer[0]=i;
                    answer[1]=j;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            String tmp=routes[i];
            String str=tmp.substring(0, tmp.indexOf(" "));
            int move=Integer.parseInt(tmp.substring(tmp.indexOf(" ")+1));
            int nx=answer[0];
            int ny=answer[1];
            boolean pass=true;
            
            for(int j=0; j<move; j++){
                int[] d=dir.get(str);
                nx+=d[0];
                ny+=d[1];
                if(nx<0 || ny<0 || nx>=h || ny>=w || board[nx][ny]==1){
                    pass=false;
                }
            }
            if(pass){
                answer[0]=nx;
                answer[1]=ny;
                System.out.println("ai="+i+" "+Arrays.toString(answer));
            }
        }
        
        return answer;
    }
}
