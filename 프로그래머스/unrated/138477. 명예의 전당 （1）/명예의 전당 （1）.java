import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> s = new ArrayList<>();
        int i = 0;

        for (int sc : score) {
            s.add(sc);
            s.sort(Collections.reverseOrder());
            if (k <= s.size()) {
                answer[i] = s.get(k - 1);
            } else {
                answer[i] = s.get(s.size() - 1);
            }
            i++;
        }

        return answer;
    }
}