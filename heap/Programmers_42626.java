/*
    Programmers 42626 [Heap]
    : 더 맵게

    처음에는 linked list 로 접근해서
    '섞은 음식'을 만들면 그 스코빌 지수를 적절히(순서에 맞게) 넣어주려고 함.
    그래서 정확성 테스트는 전부 통과했으나 효율성 테스트가... (list 탐색 시간)

    Priority Queue 컬렉션이 있음을 알게 되어 그걸로 고치니 해결!
    -> 순서에 맞게 넣어주려고 list 를 탐색하고 비교하는 부분도 필요 없게 됨. (와!)
 */


/* 정확성 테스트는 전부 통과, 효율성 테스트는 전부 통과 x */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        LinkedList<Integer> list = Arrays.stream(scoville).boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new)); // ArrayList
        int answer = 0;
        while (!list.isEmpty()) {
            int now = list.pollFirst();
            if (now < K) {
                if (list.isEmpty()) return -1;
                answer++;
                int newInt = now + list.pollFirst() * 2;
                int i = 0;
                for (Iterator<Integer> iter = list.iterator(); iter.hasNext(); i++) {
                    if (newInt <= iter.next()) break;
                }
                list.add(i, newInt);
            } else break;
        }
        return answer;
    }
}


/* PriorityQueue 로 해결 */
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] scoville, int K) {
        // 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
        PriorityQueue<Integer> pqueue = Arrays.stream(scoville).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        int answer = 0;
        while (!pqueue.isEmpty()) {
            int now = pqueue.poll();
            if (now < K) {
                if (pqueue.isEmpty()) return -1;
                answer++;
                int newInt = now + pqueue.poll() * 2;
                pqueue.add(newInt);
            } else break;
        }
        return answer;
    }
}
