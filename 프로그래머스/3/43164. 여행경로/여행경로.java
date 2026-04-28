import java.util.*;

class Point implements Comparable<Point> {
    String s, e;
    public Point(String s, String e){
        this.s=s;
        this.e=e;
    }
    
    public int compareTo(Point p){
        return this.e.compareTo(p.e);
    }
}
class Solution {
    static List<Point> list;
    static String[] answer;
    static boolean flag;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        list=new ArrayList<>();
        
        for(int i=0; i<tickets.length; i++){
            list.add(new Point(tickets[i][0], tickets[i][1]));
        }
        Collections.sort(list);
        
        for(int i=0; i<list.size(); i++){
            Point p=list.get(i);
            if(p.s.equals("ICN")) {
                visited[i]=true;
                answer[0]=p.s;
                dfs(visited, p, 1);
                visited[i]=false;
            }
        }
        
        return answer;
    }
    
    public void dfs(boolean[] visited, Point p, int depth){
        if(flag) return;
        if(depth==list.size()){
            answer[depth]=p.e;
            flag=true;
            return;
        }else {
            for(int i=0; i<list.size(); i++){
                Point np=list.get(i);
                if(!visited[i] && p.e.equals(np.s)){
                    visited[i]=true;
                    answer[depth]=np.s;
                    dfs(visited, np, depth+1);
                    visited[i]=false;
                }
            }
        }
    }
}