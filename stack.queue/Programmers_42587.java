/*
        Programmers 42587 [스택/큐]
        : 프린터

        리스트를 잘 관리해주면 됨.
*/


import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Integer> deq = Arrays.stream(priorities)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        while (!deq.isEmpty()) {
            int now = deq.removeFirst();
            location--;
            boolean flag = false;
            for (int k=now+1; k<=9; k++) {
                if (deq.contains(k)) {
                    flag = true;
                    break;
                }
            }
            if (flag) { // 더 높은 우선순위 존재
                deq.addLast(now);
                if (location == -1) { // location 도 같이 이동
                    location = deq.size()-1;
                }
            } else { // 대상출력
                answer++;
            }
            if (location == -1) break;
        }
        return answer;
    }
}
