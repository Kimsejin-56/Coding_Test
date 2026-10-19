import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int len = Integer.MAX_VALUE;
        int mi = Integer.MAX_VALUE;
        int sum = 0;
        int idx = 0;

        for (int i = 0; i <= sequence.length; i++) {
            if (sum < k && i < sequence.length) {
                sum += sequence[i];
            } else if (sum >= k) {
                sum -= sequence[idx++];
                i--;
            }
            
            if (sum == k && isBetter(len, mi, i, idx)) {
                    len = i - idx;
                    mi = idx;
                    answer[0] = idx;
                    answer[1] = i;
                }
        }

        return answer;
    }

    public boolean isBetter(int len, int mi, int i, int idx) {
        if (len != i - idx) return len > i - idx;
        return mi > idx;
    }
}