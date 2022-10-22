/*
    Programmers 42885 [Greedy]
    : 구명보트

    deque 학습하기 좋음. (array 로도 풀 수 있지만)

    반례를 찾는 데 오래 걸림.
    처음엔 그냥 정렬해서 작은 수부터 채워갔는데,
    큰 수와 작은 수의 조합이 최대의 이득을 보도록 해야 했음.
    - people=[40, 50, 150, 160], limit=200 일 때 답이 2가 되어야 함.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> deq = Arrays.stream(people).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        int answer = 0;
        int now = 0;
        while (!deq.isEmpty()) {
            now = deq.removeLast();
            while (!deq.isEmpty()) {
                int item = deq.peekFirst();
                if (now + item > limit) break;
                else if (now + item == limit) {
                    answer++;
                    now = 0;
                    deq.removeFirst();
                    break;
                } else {
                    now += item;
                    deq.removeFirst();
                }
            }
            if (now > 0) answer++;

        }
        return answer;
    }
}
