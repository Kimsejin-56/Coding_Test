import java.util.*;

class Solution {
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals("ICN")){
                visited[i]=true;
                String[] arr = new String[tickets.length+1];
                arr[0]=tickets[i][0];
                dfs(visited, tickets, 1, tickets[i][1], arr);
                visited[i]=false;
            }
        }
        
        return answer;
    }
    
    public void dfs(boolean[] visited, String[][] tickets, int depth, String str, String[] arr){
        if(depth==tickets.length){
            arr[depth]=str;
            
            if(answer[0]==null) {
                for(int i=0; i<answer.length; i++) answer[i]=arr[i];
            } else {
                System.out.println("check");
                for(int i=0; i<answer.length; i++){
                    if(!arr[i].equals(answer[i])){
                        if(arr[i].compareTo(answer[i]) < 0){
                            for(int j=0; j<answer.length; j++) answer[j]=arr[j];
                        }
                        return;
                    }
                }
            }
        }else {
            for(int i=0; i<tickets.length; i++){
                if(str.equals(tickets[i][0]) && !visited[i]){
                    visited[i]=true;
                    arr[depth]=tickets[i][0];
                    dfs(visited, tickets, depth+1, tickets[i][1], arr);
                    visited[i]=false;
                }
            }
        }
    }
}