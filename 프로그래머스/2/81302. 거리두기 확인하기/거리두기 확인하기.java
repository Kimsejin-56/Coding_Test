import java.util.*;

class Solution {
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visited;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);
       
        for(int i=0; i<places.length; i++){
            boolean pass=false;
            char [][] arr=new char[5][5];
            for(int c=0; c<5; c++){
                String str=places[i][c];
                for(int r=0; r<5; r++){
                    arr[c][r]=str.charAt(r);
                }
            }
            
            
            for(int c=0; c<arr.length; c++){
                for(int r=0; r<arr[i].length; r++){
                    if(arr[c][r]=='P'){
                        visited=new boolean[5][5];
                        if(!bfs(arr, new int[] {c,r})){ 
                            answer[i]=0;
                            pass=true;
                            break;
                        }
                    }
                }
                if(pass) break;
            }
        }
            
        return answer;
    }
    
    public boolean bfs(char[][] arr, int[] p){
        Queue<int[]> q= new ArrayDeque<>();
        int level=0;
        q.offer(p);
        visited[p[0]][p[1]]=true;
        
        while(!q.isEmpty()){
            int len=q.size();
            for(int j=0; j<len; j++){
                int cur[]=q.poll();
                
                for(int i=0; i<4; i++){
                    int nx=cur[0]+dx[i];
                    int ny=cur[1]+dy[i];
                    
                    if(nx>=0 && ny>=0 && nx<5 && ny<5 && !visited[nx][ny] && level<2){
                        if(arr[nx][ny]=='P') return false;
                    
                        if(arr[nx][ny]=='O'){
                            visited[nx][ny]=true;
                            q.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            level++;
        }
        
        return true;
    }
}