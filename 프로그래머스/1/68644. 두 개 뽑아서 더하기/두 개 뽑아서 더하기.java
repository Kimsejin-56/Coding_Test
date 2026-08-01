import java.util.*;

class Solution {
    static Set<Integer> set;
    
    public int[] solution(int[] numbers) {
        set = new HashSet<>();

        combi(0, 0, 0, numbers);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++){
            answer[i]= list.get(i);
        }

        return answer;
    }

    public void combi(int depth, int sum, int start, int[] arr){
        if (depth == 2) {
            set.add(sum);
            return;
        }else {
            for(int i=start; i<arr.length; i++){
                combi(depth+1, sum+arr[i], i+1, arr);
            }
        }
    }
}