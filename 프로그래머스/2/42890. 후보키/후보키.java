import java.util.*;

class Solution {
    static List<int[]> list;

    public int solution(String[][] relation) {
        list=new ArrayList<>();
        int size=relation[0].length;

        for(int i=1; i<=size; i++){
            dfs(0, size, 0, new int[i], relation);
        }
        
        return list.size();
    }

    public void dfs(int depth, int size, int start, int[] c, String[][] relation){
        if(depth==c.length){
            if(simulation(relation, c)) {
                if(isMinimal(c)){
                    list.add(c.clone());
                }
            }
            return;
        }else {
            for(int i=start; i<size; i++){
                c[depth]=i;
                dfs(depth+1, size, i+1, c, relation);
                c[depth]=0;
            }
        }
    }

    public boolean simulation(String[][] relation, int[] c){
        Set<String> set=new HashSet<>();

        for(int i=0; i< relation.length; i++){
            String s="";
            for(int j=0; j<c.length; j++){
                s+=relation[i][c[j]]+" ";
            }
            set.add(s);
        }

        if(set.size()==relation.length) return true;
        return false;
    }

    public boolean isMinimal(int[] c){
        for(int[] key : list){
            int count=0;

            for(int x : c){
                for(int k : key){
                    if(x==k){
                        count++;
                        break;
                    }
                }
            }

            if(count==key.length) return false;
        }

        return true;
    }
}