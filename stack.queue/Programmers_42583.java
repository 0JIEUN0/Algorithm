/*
        Programmers 42583 [스택/큐]
        : 다리를 지나는 트럭

        다리에 트럭을 올릴 수 있다면, 해당 트럭의 무게를 queue 에 넣음.
        그럴 수 없다면, 다리의 길이를 고려해주기 위해 dummy data 인 0을 넣음.
        - ex. bridge_length=100, weight=100, truck_weights=[10] 이면
          첫 번째 트럭이 다리에 올라가는 순간 queue 값: [0, 0, 0, 0, 0, 0, 0, 0, 0, 10]
          ('10'이 다리를 온전히 건너기 위해서는 10만큼을 가야 하므로)
*/


import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int nowN = 0, nowS = 0, cnt = 0, i = 0;
        int n = truck_weights.length;
        for (int j=0; j<bridge_length-1; j++) queue.add(0); // dummy
        do {
            int w = i<n ? truck_weights[i] : weight+1; // i 가 n 까지
            if (i == n) queue.poll(); // 남은 트럭 없음
            else if (queue.size() == bridge_length) {
                nowS -= queue.poll();
                nowN--;
            }
            if (nowN < bridge_length && nowS + w <= weight) { // go!
                queue.add(w);
                nowN++;
                nowS += w;
                i++;
            } else if (i != n) {
                queue.add(0); // dummy
                nowN++;
            }
            cnt++;
        } while (!queue.isEmpty());
        return cnt;
    }
}
