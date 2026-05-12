import java.util.*;

class Solution {
    static List<String> list, answer;
    static int max;
    static Map<Integer, List<String>> map;
    public String[] solution(String[] orders, int[] course) {
        Set<String> set=new HashSet<>();
        map=new HashMap<>();
        for(int i=0; i<orders.length; i++){
            String order=orders[i];
            for(int j=0; j<order.length(); j++){
                String str=String.valueOf(order.charAt(j));
                set.add(str);
            }
        }
        list=new ArrayList<>(set);
        answer=new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            max=0;
            dfs(0, new String[course[i]], 0, orders);
            if(max==0) continue;
            for(String str : map.get(max)) {
                answer.add(str);
            }
            map.clear();
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    public void dfs(int depth, String[] arr, int start, String[] orders){
        if(depth == arr.length){
            int count=0;
            for(int i=0; i<orders.length; i++){
                String order=orders[i];
                boolean pass=true;
                for(int j=0; j<arr.length; j++){
                    if(!order.contains(arr[j])){
                        pass=false;
                        break;
                    } 
                }
                if(pass) count++;
            }
            
            if(count>=2) {
                String tmp="";
                for(int i=0; i<arr.length; i++) tmp+=arr[i];
                max=Math.max(max, count);
                map.putIfAbsent(count, new ArrayList<>());
                map.get(count).add(tmp);
            }
        } else{
            for(int i=start; i<list.size(); i++){
                arr[depth]=list.get(i);
                dfs(depth+1, arr, i+1, orders);
            }
        }
    }
}