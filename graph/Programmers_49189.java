/*
    Programmers 49189 [Graph]
    : 가장 먼 노드

    edge를 map 으로 정리해두고,
    1번 노드부터 시작해서 연결된 노드들을 탐색
    - 해당 노드의 현재 경로보다 짧은 경우, 업데이트 및 해당 노드의 주변 노드 탐색
    - 값이 바뀌는 노드의 주변 노드를 (재)탐색하는 이유: 짧은 거리의 연결 정보가 뒤에 올 수도.
      (이 경우를 고려해주지 않아서 처음에 실패했음)
 */


import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int n, int[][] edge) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int[] e: edge) {
            if (map.containsKey(e[0])) map.get(e[0]).add(e[1]);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(e[1]);
                map.put(e[0], list);
            }
            if (map.containsKey(e[1])) map.get(e[1]).add(e[0]);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(e[0]);
                map.put(e[1], list);
            }
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, 500000);
        dist[0] = dist[1] = 0;
        deep(1, dist, map);

        int max = Arrays.stream(dist).max().getAsInt();
        int answer = 0;
        for (int d: dist) {
            if (d == max) answer++;
        }
        return answer;
    }

    public static void deep(int now, int[] dist, Map<Integer, ArrayList<Integer>> map) {
        map.get(now).forEach((x)->{
            if (dist[now]+1 < dist[x]) {
                dist[x] = dist[now]+1;
                deep(x, dist, map);
            }
        });
    }
}
