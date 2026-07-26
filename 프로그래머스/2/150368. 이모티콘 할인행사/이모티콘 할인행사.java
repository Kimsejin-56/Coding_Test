import java.util.*;

class Result implements Comparable<Result>{
    int plus, price;
    public Result(int plus, int price){
        this.plus=plus;
        this.price=price;
    }
    
    public int compareTo(Result r){
        if(r.plus==this.plus) return r.price - this.price;
        return r.plus - this.plus;
    }
}

class Solution {
    static int[] apply;
    static List<Result> list;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        apply=new int[emoticons.length];
        list=new ArrayList<>();
        dfs(0, emoticons, users);
        
        Collections.sort(list);
        answer[0]=list.get(0).plus;
        answer[1]=list.get(0).price;
        return answer;
    }
    
    public void dfs(int depth, int[] emoticons, int[][]users){
        if(depth==emoticons.length){
            buy(users, emoticons);
        } else{
            for(int i=1; i<=4; i++){
                apply[depth]=i*10;
                dfs(depth+1, emoticons, users);
            }
        }
    }
    
    public void buy(int[][] users, int[] emoticons){
        int plus=0;
        int total=0;
        for(int i=0; i<users.length; i++){
            int temp=0;
            int discount=users[i][0];
            int price=users[i][1];
            
            for(int j=0; j<emoticons.length; j++){
                if(apply[j]<discount) continue;
            
                temp+=emoticons[j]-(emoticons[j]/100 * apply[j]);
            }
            
            if(temp>=price) plus++;
            else total+=temp;
            
            list.add(new Result(plus, total));
        }
    } 
}