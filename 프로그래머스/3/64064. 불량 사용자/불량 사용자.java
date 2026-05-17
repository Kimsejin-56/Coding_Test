import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    static String[] arr;
    static List<String[]> list;
    public int solution(String[] user_id, String[] banned_id) {
        answer = 0;
        arr=new String[banned_id.length];
        list=new ArrayList<>();
        visited=new boolean[user_id.length];
        dfs(0, user_id, banned_id, visited);
        return answer;
    }
    
    public void dfs(int depth, String[] user_id, String[] banned_id, boolean[] visited){
        if(depth==banned_id.length){
            if(list.isEmpty()) list.add(Arrays.copyOf(arr, depth));
            else {
                for(int i=0; i<list.size(); i++){
                    String[] tmp=list.get(i);
                    int cnt=0;
                    for(int j=0; j<tmp.length; j++){
                        for(int k=0; k<tmp.length; k++){
                            if(tmp[j].equals(arr[k])) {
                                cnt++;
                                break;
                            }
                        }
                    }
                    if(cnt == depth) return;
                }
            }
            
            answer++;
            list.add(Arrays.copyOf(arr, depth));
            return;
        } else{
            String ban=banned_id[depth];
            for(int i=0; i<user_id.length; i++){
                if(visited[i]) continue;
                String user=user_id[i];
                int len=user.length();
                
                if(user.length() != ban.length()) continue;
                
                for(int j=0; j<ban.length(); j++){
                    if(ban.charAt(j)=='*') len--;
                    else if(ban.charAt(j)==user.charAt(j)) len--;
                    else break;
                }
                
                if(len==0) {
                    visited[i]=true;
                    arr[depth]=user;
                    dfs(depth+1, user_id, banned_id, visited);
                    visited[i]=false;
                }
            }  
        }
    }
}